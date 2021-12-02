package com.demoapigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
                
                // lb:/// Load Balance
                .route(p -> p.path("/demo-microservice/**")
                        .uri("lb://demo-microservice"))
                
                .route(p -> p.path("/demo-feign-microservice/**")
                        .uri("lb://demo-feign-microservice"))
                
                // Redirigir una ruta
                .route(p -> p.path("/demo-feign-microservice-new/**")
                        .filters(f -> f.rewritePath(
                                "/demo-feign-microservice-new/(?<segment>.*)", 
                                "/demo-feign-microservice/${segment}"))
                        .uri("lb://demo-feign-microservice"))
                .build();
    }
}
# Demo Feign Microservice

### Dependencies

* Spring Web
* OpenFeign
* Eureka Discovery Client

### Run

```shell
docker rmi demo-feign-microservice -f
mvn clean install -DskipTests=true
docker-compose down
docker-compose up
# or
# docker-compose up -d
```
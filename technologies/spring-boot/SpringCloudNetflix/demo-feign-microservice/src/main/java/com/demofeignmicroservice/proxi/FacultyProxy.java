package com.demofeignmicroservice.proxi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demofeignmicroservice.model.Faculty;

// @FeignClient(name="demo-microservice", url = "http://demo-microservice:8000") // docker post in network
@FeignClient(name="demo-microservice")
public interface FacultyProxy {
	
	@GetMapping("/demo-microservice/faculty/id/{id}")
	public Faculty findFacultyById(@PathVariable Long id);
}

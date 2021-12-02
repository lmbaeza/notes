package com.demofeignmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demofeignmicroservice.model.Faculty;
import com.demofeignmicroservice.proxi.FacultyProxy;

@RestController
@RequestMapping(path = "/demo-feign-microservice/faculty")
public class FacultyController {
	
	@Autowired
	private FacultyProxy proxy;
	
	@GetMapping(value = {"/any/{id}"})
	private Faculty findFacultyById(@PathVariable Long id) {
		Faculty faculty = proxy.findFacultyById(id);
		return faculty;
	}
}

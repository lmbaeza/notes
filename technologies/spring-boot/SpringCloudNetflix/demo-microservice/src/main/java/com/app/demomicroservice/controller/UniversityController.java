package com.app.demomicroservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demomicroservice.service.UniversityService;
import com.app.demomicroservice.model.University;

// @CrossOrigin
@RestController
@RequestMapping(path = "/demo-microservice/university")
public class UniversityController {
	
	// @Autowired
	private UniversityService universityService;
	
	public UniversityController(UniversityService universityService) {
		this.universityService = universityService;
    }
	
	@GetMapping(value = { "/all" })
	private List<University> all() {
		return universityService.findAll();
	}
	
	@GetMapping(value = {"/id/{id}"})
	private University findById(@PathVariable Long id) {
		return universityService.findById(id);
	}
}

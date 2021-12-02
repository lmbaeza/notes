package com.app.demomicroservice.controller;

import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demomicroservice.model.Faculty;
import com.app.demomicroservice.service.FacultyService;

//@CrossOrigin
@RestController
@RequestMapping(path = "/demo-microservice/faculty")
public class FacultyController {

	// @Autowired
	private FacultyService facultyService;
	
	public FacultyController(FacultyService facultyService) {
		this.facultyService = facultyService;
    }
	
	@GetMapping(value = { "/all" })
	private List<Faculty> all() {
		return facultyService.findAll();
	}
	
	@GetMapping(value = {"/id/{id}"})
	private Faculty findById(@PathVariable Long id) {
		return facultyService.findById(id);
	}
	
	static Random rand = new Random();
	private static final Integer id = rand.nextInt(1000);
	
	@GetMapping(value = {"/ping"})
	private String ping() {
		return "(Pong) Host Id: " + id.toString();
	}
}

package com.app.demomicroservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.demomicroservice.model.Faculty;
import com.app.demomicroservice.repository.FacultyRepository;

@Service
public class FacultyService implements IFacultyService {
		
	// @Autowired
	private final FacultyRepository facultyRepository;
	
	public FacultyService(FacultyRepository facultyRepository) {
		this.facultyRepository = facultyRepository;
	}
	
	@Override
	public List<Faculty> findAll() {
		return (List<Faculty>) facultyRepository.findAll();
	}

	@Override
	public Faculty findById(Long id) {
		return facultyRepository.findById(id).orElse(null);
	}
}
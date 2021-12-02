package com.app.demomicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demomicroservice.model.University;
import com.app.demomicroservice.repository.UniversityRepository;

@Service
public class UniversityService implements IUniversityService {
	
	// @Autowired
	private final UniversityRepository universityRepository;
	
	public UniversityService(UniversityRepository universityRepository ){
		this.universityRepository = universityRepository;
    }

	@Override
	public List<University> findAll() {
		return (List<University>) universityRepository.findAll();
	}

	@Override
	public University findById(Long id) {
		return universityRepository.findById(id).orElse(null);
	}
}
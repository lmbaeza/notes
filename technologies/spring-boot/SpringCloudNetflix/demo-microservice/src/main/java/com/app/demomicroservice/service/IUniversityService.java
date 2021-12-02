package com.app.demomicroservice.service;


import java.util.List;

import com.app.demomicroservice.model.University;

public interface IUniversityService {
	public List<University> findAll();
	public University findById(Long id);
}

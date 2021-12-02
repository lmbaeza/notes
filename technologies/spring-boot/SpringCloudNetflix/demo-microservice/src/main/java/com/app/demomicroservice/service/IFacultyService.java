package com.app.demomicroservice.service;

import java.util.List;

import com.app.demomicroservice.model.Faculty;

public interface IFacultyService {
	public List<Faculty> findAll();
	public Faculty findById(Long id);
}

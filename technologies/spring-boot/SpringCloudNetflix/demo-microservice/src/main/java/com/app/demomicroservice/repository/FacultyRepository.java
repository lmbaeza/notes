package com.app.demomicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demomicroservice.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {}
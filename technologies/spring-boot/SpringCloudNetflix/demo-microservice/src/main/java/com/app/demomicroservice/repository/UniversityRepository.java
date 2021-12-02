package com.app.demomicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demomicroservice.model.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {}
package com.tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entity.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {

}

package com.tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.entity.StudentEnqEntity;

@Repository
public interface StudentEnqRepo extends JpaRepository<StudentEnqEntity, Integer> {

}

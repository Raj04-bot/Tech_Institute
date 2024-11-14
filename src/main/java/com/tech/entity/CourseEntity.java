package com.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="courses")
public class CourseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer course_id;
	private String course_name;
	
	
	

}

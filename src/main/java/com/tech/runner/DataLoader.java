 package com.tech.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tech.entity.CourseEntity;
import com.tech.entity.EnqStatusEntity;
import com.tech.repo.CourseRepo;
import com.tech.repo.EnqStatusRepo;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private EnqStatusRepo statusRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		courseRepo.deleteAll();
		
		CourseEntity c1 = new CourseEntity();
		c1.setCourseName("Java");
		 
		CourseEntity c2 = new CourseEntity();
		c2.setCourseName("AWS");
		
		CourseEntity c3 = new CourseEntity();
		c3.setCourseName("Python");
		
		CourseEntity c4 = new CourseEntity();
		c4.setCourseName("Devops");
		
		courseRepo.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		statusRepo.deleteAll();
		
		EnqStatusEntity s1 = new EnqStatusEntity();
		s1.setStatusName( "New");
		
		EnqStatusEntity s2 = new EnqStatusEntity();
		s2.setStatusName("Enrolled");
		
		
		EnqStatusEntity s3 = new EnqStatusEntity();
		s3.setStatusName("Lost");
		
		statusRepo.saveAll(Arrays.asList(s1, s2, s3));
	}
			
		
	
	
	

}

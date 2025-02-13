package com.tech.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.tech.dto.DashBoardResponse;
import com.tech.dto.EnquiryForm;
import com.tech.entity.CourseEntity;
import com.tech.entity.EnqStatusEntity;
import com.tech.entity.StudentEnqEntity;
import com.tech.entity.UserDtlsEntity;
import com.tech.repo.CourseRepo;
import com.tech.repo.EnqStatusRepo;
import com.tech.repo.StudentEnqRepo;
import com.tech.repo.UserDtlsRepo;

import jakarta.persistence.Entity;
import jakarta.servlet.http.HttpSession;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	
	@Autowired
	private UserDtlsRepo userDtlsRepo;
	
	@Autowired
	private StudentEnqRepo enqRepo;
	
	@Autowired
	private CourseRepo coursesRepo;
	
	@Autowired
	private EnqStatusRepo statusRepo;
	
	@Autowired 
	private HttpSession session;
	
	
	
	@Override
	public DashBoardResponse getDashBoardData(Integer userID) {
		
		// TODO Auto-generated method stub
		DashBoardResponse response = new DashBoardResponse();
		
			Optional<UserDtlsEntity> findById = userDtlsRepo.findById(userID);
		
		if (findById.isPresent()) {
			UserDtlsEntity userEntity = findById.get();
			
			List<StudentEnqEntity> enquiries = userEntity.getEnquries();
			     
			// this is total count 
				Integer totalCnt	= enquiries.size();
				
			 // this is total enrolled count        
			Integer  enrolledCnt = enquiries.stream()
			 		  .filter(e -> e.getEnqStatus().equals("Enrolled") )
			 		  .collect( Collectors.toList()) .size();
			
			// total lost coount 
			   Integer lostCnt = enquiries.stream()
			     .filter(e -> e.getEnqStatus().equals("Lost"))
			     .collect(Collectors.toList()).size();
			
			response.setTotalEnquries(totalCnt);
			response.setEnrolled(enrolledCnt);
			response.setLost(lostCnt);
			
		}
											
		
		return null;
	}



	@Override
	public List<String> getCourses() {
	List<CourseEntity> findAll	= coursesRepo.findAll();
	
	List<String> names = new ArrayList();
	
	for (CourseEntity entity : findAll)
	{
		names.add(entity.getCourseName());
	}
		
		return names;
	}



	@Override
	public List<String> getEnqStatuses() {
		
		// TODO Auto-generated method stub
			List<EnqStatusEntity> findAll = statusRepo.findAll();
			
			List<String> statusList = new ArrayList<>();
			
			for(EnqStatusEntity Entity : findAll)
			{
				statusList.add(Entity.getStatusName());
			}
					
		return statusList;
	}



	@Override
	public boolean saveEnquiry(EnquiryForm form) {
				
		StudentEnqEntity enqEntity = new StudentEnqEntity();
		BeanUtils.copyProperties(form,enqEntity);
		
		Integer userId = (Integer) session.getAttribute("userId");
		
		UserDtlsEntity userEntity = userDtlsRepo.findById(userId).get();
		enqEntity.setUser(userEntity);
				
		enqRepo.save(enqEntity);
		
		return true;
	}



	
	
	
	

}

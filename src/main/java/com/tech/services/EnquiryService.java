 package com.tech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.dto.DashBoardResponse;
import com.tech.dto.EnquiryForm;
import com.tech.dto.EnquirySearchCriteria;
@Service
public interface EnquiryService {
	

	public DashBoardResponse getDashBoardData(Integer userID);
	
	

}

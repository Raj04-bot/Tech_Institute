package com.tech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.dto.DashBoardResponse;
import com.tech.dto.EnquiryForm;
import com.tech.dto.EnquirySearchCriteria;
@Service
public interface EnquiryService {
	
	public List<String > getCoursename();
	
	public List<String>getEnqStatus();
	
	public DashBoardResponse dashBoardResponse(Integer userID);
	
	public String upsertEnquiry(EnquiryForm enquiryForm);
	// upsert enquiry is used to both insert and update
	
	public List<EnquiryForm> getEnquries(Integer userID,EnquirySearchCriteria criteria);
	
	public EnquiryForm getEnquiry(Integer enqid);
	

}

package com.tech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.dto.DashBoardResponse;
import com.tech.dto.EnquiryForm;
import com.tech.dto.EnquirySearchCriteria;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	
	@Override
	public List<String> getCoursename() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getEnqStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DashBoardResponse dashBoardResponse(Integer userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upsertEnquiry(EnquiryForm enquiryForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnquiryForm> getEnquries(Integer userID, EnquirySearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnquiryForm getEnquiry(Integer enqid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}

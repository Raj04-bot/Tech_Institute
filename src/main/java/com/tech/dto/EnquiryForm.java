package com.tech.dto;

import javax.print.event.PrintJobAttributeEvent;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import lombok.Data;

@Data
public class EnquiryForm {
	
	private String studentName;
	
	private Long phno;
	
	private String classMode;
	
	private String courseName;
	
	private String enqStatus;
	

}

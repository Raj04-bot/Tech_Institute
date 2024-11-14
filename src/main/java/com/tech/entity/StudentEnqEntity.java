package com.tech.entity;

import java.util.Date;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ValueGenerationType;
import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student_enq")
public class StudentEnqEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer enqid;
	private String stydentName;
	private Integer phoneNo;
	private String class_mode;
	private String course_name;
	private String enqStatus;
	private Date enq_creationDate;
	private Date updated_Date;
		

}

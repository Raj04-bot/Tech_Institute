package com.tech.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private Long phno;
	private String class_mode;
	private String course_name;
	private String enqStatus;
	private Date enq_creationDate;
	private Date updated_Date;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id") 
	 // Foreign key column in the database, referencing userID in UserDtlsEntity
	    private UserDtlsEntity user;
		

}

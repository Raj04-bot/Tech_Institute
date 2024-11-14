package com.tech.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertFalse.List;
import lombok.Data;

@Data
@Entity
@Table(name="user_dtls")
public class UserDtlsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userID;
	private String name;
	private String email;
	private Long mobileNo;
	private String password;
	private String accstatus;
	
	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private List<StudentEnqEntity> enquries;
	
	
	
	
	

}

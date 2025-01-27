package com.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="enq_status")
public class EnqStatusEntity {
	
	@Id
	@GeneratedValue
	private Integer statusID;
	private String statusName;
	

}

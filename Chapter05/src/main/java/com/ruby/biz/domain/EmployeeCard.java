package com.ruby.biz.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude="employee")
@Entity
@Table(name = "S_EMP_CARD")
public class EmployeeCard
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARD_ID")
	private Long cardId;	// 사원증 아이디
	
	@Column(name = "EXPIRE_DATE")
	private Date expireDate;	// 사원증 만료 기간
	
	private String role;		// 권한
		
	@OneToOne(mappedBy = "card")
	private Employee employee;
	

}

package com.ruby.biz.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
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
	@Column(name = "CARD_ID")
	private Long cardId;	// 사원증 아이디
	
	@Column(name = "EXPIRE_DATE")
	private Date expireDate;	// 사원증 만료 기간
	
	private String role;		// 권한
	
	@MapsId	
	@OneToOne
	@JoinColumn(name = "EMP_ID")
	private Employee employee;	

}

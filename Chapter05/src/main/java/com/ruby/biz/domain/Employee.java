package com.ruby.biz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "S_EMP")
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 25, nullable = false)
	private String name;
	
	@OneToOne(mappedBy = "employee")
	private EmployeeCard card;
	
	public void setEmployeeCard(EmployeeCard card)
	{
		this.card = card;
		card.setEmployee(this);
	}
	
}

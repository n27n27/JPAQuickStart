package com.ruby.biz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="S_EMP")
@TableGenerator(name = "SEQ_GENERATOR",
				table = "SHOPPING_SEQUENCES",
				pkColumnName = "SEQ_NAME",
				pkColumnValue = "EMP_SEQ",
				valueColumnName = "NEXT_VALUE",
				initialValue = 0,
				allocationSize = 1)
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,
					generator = "S_EMP_GENERATOR")
	private Long id;	
	private String name;		
	
}

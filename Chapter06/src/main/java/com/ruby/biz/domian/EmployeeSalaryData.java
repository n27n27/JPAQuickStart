package com.ruby.biz.domian;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeSalaryData
{
	private Long id;
	
	private Double salary;
	
	private Double commissionPct;
}

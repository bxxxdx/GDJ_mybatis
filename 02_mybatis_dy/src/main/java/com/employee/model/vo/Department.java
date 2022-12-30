package com.employee.model.vo;

import java.util.List;

import lombok.Data;

@Data
public class Department {
	private String deptId;
	private String deptTitle;
	private String locationId;
	private List<Employee> employees;
	
	@Override
	public String toString() {
		String temp = "";
		for(Employee e : employees) {
			temp += "emp : " + e.getEmpName() + e.getEmpNo() + e.getSalary();
		}
		return deptId + " " + deptTitle + " " + locationId + " " + temp;
	}
}

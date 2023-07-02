/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeepayroll.employee;

import com.mycompany.employeepayroll.enums.EmployeeType;
import java.util.Date;

/**
 *
 * @author Arian
 */
public class ContractorEmployee extends Employee{

	private Date contractEndDate;
	private double hourlyRate;


	public ContractorEmployee(String firstName, String lastName, String email, String phoneNumber, Date hireDate,  String jobId, double salary, int managerId,int departmentId, EmployeeType employeeType){
	super(firstName, lastName, email, phoneNumber, hireDate, jobId, salary, managerId, departmentId, employeeType);
	
	}
	public ContractorEmployee(int id, String firstName, String lastName, String email, String phoneNumber, Date hireDate, String jobId,double salary, int managerId,int departmentId, EmployeeType employeeType){
	super(id, firstName, lastName, email, phoneNumber, hireDate, jobId, salary, managerId, departmentId, employeeType);
	
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ContractorEmployee{");
		sb.append("contractEndDate=").append(contractEndDate);
		sb.append(", hourlyRate=").append(hourlyRate);
		sb.append('}');
		return sb.toString();
	}
		
	
}

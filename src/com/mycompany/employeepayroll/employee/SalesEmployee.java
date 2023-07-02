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
public class SalesEmployee extends RegularEmployee{
    	private double commissionPercentage;


    public SalesEmployee(int id, String firstName, String lastName, String email, String phoneNumber,Date hireDate, String jobId, double salary,int managerId, int departmentId, EmployeeType employeeType, double commissionPercentage) {
	super(id, firstName, lastName, email, phoneNumber, hireDate, jobId, salary, managerId, departmentId, employeeType);
	this.commissionPercentage = commissionPercentage;
    }
    public SalesEmployee( String firstName, String lastName, String email, String phoneNumber,Date hireDate, String jobId, double salary,int managerId, int departmentId, EmployeeType employeeType, double commissionPercentage) {
	super(firstName, lastName, email, phoneNumber, hireDate, jobId, salary, managerId, departmentId, employeeType);
	this.commissionPercentage = commissionPercentage;
    }

	public double getCommissionPercentage() {
		return commissionPercentage;
	}
    
	
}

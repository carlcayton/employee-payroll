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
public class RegularEmployee extends Employee{

	
       public RegularEmployee() {
	       super("John", "Doe", "john.doe@example.com", "1234567890",new Date(), "ST_CLERK", 0.0, 0, 0, EmployeeType.REGULAR);
    }
    
 
	public RegularEmployee(String firstName, String lastName, String email, String phoneNumber,Date hireDate, String jobId, double salary,int managerId, int departmentId, EmployeeType employeeType){
		super(firstName, lastName, email, phoneNumber, hireDate, jobId, salary, managerId, departmentId, employeeType);
	}
	public RegularEmployee(int id, String firstName, String lastName, String email, String phoneNumber,Date hireDate, String jobId, double salary,int managerId, int departmentId, EmployeeType employeeType){
	super(id, firstName, lastName, email, phoneNumber, hireDate, jobId, salary, managerId, departmentId, employeeType);
	}
	
	
}

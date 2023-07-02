/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeepayroll.factory;

import com.mycompany.employeepayroll.employee.ContractorEmployee;
import com.mycompany.employeepayroll.employee.RegularEmployee;
import com.mycompany.employeepayroll.employee.SalesEmployee;
import com.mycompany.employeepayroll.enums.EmployeeType;
import java.util.Date;

/**
 *
 * @author Arian
 */
public class EmployeeFactory {
    
    public static RegularEmployee createRegularEmployee(String firstName, String lastName, String email, String phoneNumber,
            Date hireDate, String jobId, double salary, int managerId, int departmentId, EmployeeType employeeType) {
        return new RegularEmployee(firstName, lastName, email, phoneNumber, hireDate, jobId, salary, managerId, departmentId, employeeType);
    }
    
    public static ContractorEmployee createContractorEmployee(String firstName, String lastName, String email, String phoneNumber,
            Date hireDate, String jobId, double salary, int managerId, int departmentId, EmployeeType employeeType) {
        return new ContractorEmployee(firstName, lastName, email, phoneNumber, hireDate, jobId, salary, managerId, departmentId, employeeType);
    }
    
    public static SalesEmployee createSalesEmployee(String firstName, String lastName, String email, String phoneNumber,
            Date hireDate, String jobId, double salary, double commissionPercentage,
	    int managerId, int departmentId, EmployeeType employeeType) {
        return new SalesEmployee(firstName, lastName, email, phoneNumber, hireDate, jobId, salary, managerId, departmentId, employeeType, commissionPercentage);
    }
}
	


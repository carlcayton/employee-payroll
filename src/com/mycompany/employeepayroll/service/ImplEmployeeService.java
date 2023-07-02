/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeepayroll.service;

/**
 *
 * @author Arian
 */
import com.mycompany.employeepayroll.DataAccess.EmployeeDataAccess;
import com.mycompany.employeepayroll.employee.Employee;
import java.util.List;

public class ImplEmployeeService implements EmployeeService{
	private EmployeeDataAccess employeeDataAccess;

		
	public ImplEmployeeService(EmployeeDataAccess employeeDataAccess){
		this.employeeDataAccess = employeeDataAccess;
	}


    @Override
    public Employee getEmployeeById(int employeeId) {
        // Additional business logic or validation if needed
        return employeeDataAccess.getEmployeeById(employeeId);
    }

    @Override deleteEmployee(int id){
	   return employeeDataAccess.delete
	    
    }
    @Override
    public List<Employee> getAllEmployees() {
        // Additional business logic or validation if needed
        return employeeDataAccess.getAllEmployees();
    }

    @Override
    public void addEmployee(Employee employee) {
        // Additional business logic or validation if needed
        employeeDataAccess.addEmployee(employee);
    }

	@Override
	public List<Employee> searchEmployeesByName(String name) {
		return null;
	}

	public void extendContract(int employeeId, int newContractDuration){
		
	}

	
}

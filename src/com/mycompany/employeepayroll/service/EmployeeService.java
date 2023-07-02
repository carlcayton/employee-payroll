/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeepayroll.service;

import com.mycompany.employeepayroll.employee.Employee;
import java.util.List;

/**
 *
 * @author Arian
 */
public interface EmployeeService {
	 void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();
    List<Employee> searchEmployeesByName(String name);
    void extendContract(int employeeId, int newContractDuration);
	
}

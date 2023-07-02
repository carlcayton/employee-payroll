/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeepayroll.DataAccess;

import com.mycompany.employeepayroll.employee.Employee;
import java.util.List;

/**
 *
 * @author Arian
 */
public interface EmployeeDataAccess {
  void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();	
    List<String> getAllJobIds();
    int getRandomEmployeeId();
    int getRandomDepartmentId();
}

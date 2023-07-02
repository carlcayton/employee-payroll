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
public abstract class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private double salary;
    private int managerId;
    private int departmentId;
    private final EmployeeType employeeType;


    public Employee(int id, String firstName, String lastName, String email, String phoneNumber,Date hireDate, String jobId, double salary,int managerId, int departmentId, EmployeeType employeeType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
//        this.commissionPercentage = commissionPercentage;
        this.managerId = managerId;
        this.departmentId = departmentId;
	this.employeeType = employeeType;
    }
    public Employee(String firstName, String lastName, String email, String phoneNumber,Date hireDate, String jobId, double salary,int managerId, int departmentId, EmployeeType employeeType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
//        this.commissionPercentage = commissionPercentage;
        this.managerId = managerId;
        this.departmentId = departmentId;
	this.employeeType = employeeType;
    }

    // Getters and setters for the attributes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
/*
    public double getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(double commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }*/

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    // Abstract method to be implemented by subclasses
    public double calculatePayroll(double deductions){
	return this.salary-deductions;
    };

    // Other common methods for employee management

    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Employee{");
		sb.append("id=").append(id);
		sb.append(", firstName=").append(firstName);
		sb.append(", lastName=").append(lastName);
		sb.append(", email=").append(email);
		sb.append(", phoneNumber=").append(phoneNumber);
		sb.append(", hireDate=").append(hireDate);
		sb.append(", jobId=").append(jobId);
		sb.append(", salary=").append(salary);
		sb.append(", managerId=").append(managerId);
		sb.append(", departmentId=").append(departmentId);
		sb.append(", employeeType=").append(employeeType);
		sb.append('}');
		return sb.toString();
	}
    

    
}

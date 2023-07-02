/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeepayroll.DataAccess;

import com.mycompany.employeepayroll.employee.Employee;
import com.mycompany.employeepayroll.employee.RegularEmployee;
import com.mycompany.employeepayroll.employee.SalesEmployee;
import com.mycompany.employeepayroll.util.DatabaseManager;
import java.sql.Connection;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Arian
 */


public class ImplEmployeeDataAccess implements EmployeeDataAccess {

    private Connection connection;

    public ImplEmployeeDataAccess(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee employee = null;
        String query = "SELECT * FROM Employees WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employee = extractEmployeeFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employees";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Employee employee = extractEmployeeFromResultSet(resultSet);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO Employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_percentage, manager_id, department_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employee.getId());
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getPhoneNumber());
	    java.util.Date utilHireDate = employee.getHireDate();
Instant instant = utilHireDate.toInstant();
LocalDate hireDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
		statement.setObject(5, java.sql.Date.valueOf(hireDate));
            statement.setString(6, employee.getJobId());
            statement.setDouble(7, employee.getSalary());
	    if (employee instanceof SalesEmployee) {
                SalesEmployee salesEmployee = (SalesEmployee) employee;
                statement.setDouble(8, salesEmployee.getCommissionPercentage());
            } else {
                // Set a default value if the employee is not a SalesEmployee
                statement.setNull(8, java.sql.Types.DOUBLE);
            }
            statement.setInt(9, employee.getManagerId());
            statement.setInt(10, employee.getDepartmentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Utility method to extract Employee from ResultSet
    private Employee extractEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
//	    System.out.println(resultSet.getInt("employee_id"));
        Employee employee = new RegularEmployee();
        employee.setId(resultSet.getInt("employee_id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setEmail(resultSet.getString("email"));
        employee.setPhoneNumber(resultSet.getString("phone_number"));
        // Set other attributes from ResultSet as needed
        return employee;
    }
     public List<String> getAllJobIds() {
        List<String> jobIds = new ArrayList<>();
        String query = "SELECT job_id FROM jobs";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String jobId = resultSet.getString("job_id");
                jobIds.add(jobId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobIds;
     }
     public int getRandomEmployeeId() {
        int employeeId = 0;
        String query = "SELECT employee_id FROM Employees";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            List<Integer> employeeIds = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                employeeIds.add(id);
            }
            if (!employeeIds.isEmpty()) {
                Random random = new Random();
                int index = random.nextInt(employeeIds.size());
                employeeId = employeeIds.get(index);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeId;
    }
      public int getRandomDepartmentId() {
        int departmentId = 0;
        String query = "SELECT department_id FROM Departments";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            List<Integer> departmentIds = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("department_id");
                departmentIds.add(id);
            }
            if (!departmentIds.isEmpty()) {
                Random random = new Random();
                int index = random.nextInt(departmentIds.size());
                departmentId = departmentIds.get(index);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentId;
    }

	@Override
	public void updateEmployee(Employee employee) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void deleteEmployee(int employeeId) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}


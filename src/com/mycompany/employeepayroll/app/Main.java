/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeepayroll.app;

import com.mycompany.employeepayroll.DataAccess.EmployeeDataAccess;
import com.mycompany.employeepayroll.DataAccess.ImplEmployeeDataAccess;
import com.mycompany.employeepayroll.employee.ContractorEmployee;
import com.mycompany.employeepayroll.employee.Employee;
import com.mycompany.employeepayroll.employee.RegularEmployee;
import com.mycompany.employeepayroll.employee.SalesEmployee;
import com.mycompany.employeepayroll.enums.EmployeeType;
import com.mycompany.employeepayroll.factory.EmployeeFactory;
import com.mycompany.employeepayroll.service.EmployeeService;
import com.mycompany.employeepayroll.service.ImplEmployeeService;
import com.mycompany.employeepayroll.service.ImplPayrollRecordService;
import com.mycompany.employeepayroll.service.PayrollRecordService;
import com.mycompany.employeepayroll.util.DatabaseManager;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Arian
 */
public class Main {
		static DatabaseManager databaseManager = new DatabaseManager();
//		Connection connection = databaseManager.getConnection();
		static EmployeeDataAccess employeeDataAccess = new ImplEmployeeDataAccess(databaseManager.getConnection());
	public static void main(String[] args) {
		Main.run();
		;
	}

	public static void run(){
        	Scanner scanner = new Scanner(System.in);
//		DatabaseManager databaseManager = new DatabaseManager();
//		Connection connection = databaseManager.getConnection();
//		EmployeeDataAccess employeeDataAccess = new ImplEmployeeDataAccess(databaseManager.getConnection());
        int choice;
        boolean exit = false;
        
        while (!exit) {
            System.out.println("Welcome to the Employee Management System!");
            System.out.println("Please select an option:");
            System.out.println("1. Employee Management");
            System.out.println("2. Payroll Management");
            System.out.println("3. Exit");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    employeeManagement(scanner);
                    break;
                case 2:
//                    payrollManagement(scanner);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println();
        }
        
        System.out.println("Thank you for using the Employee Management System!");
    }
    
    public static void employeeManagement(Scanner scanner 
) {
        EmployeeService employeeService = new ImplEmployeeService(employeeDataAccess);
        int choice;
        
        while (true) {
            System.out.println("Employee Management");
            System.out.println("Please select an option:");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View Employee Details");
            System.out.println("5. Back to Main Menu");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
		    Employee employee = showPromptsForAddEmployee(scanner);
                    employeeService.addEmployee(employee);
                    break;
                case 2:
//                    employeeService.updateEmployee();
                    break;
                case 3:
//                    employeeService.deleteEmployee();
                    break;
                case 4:
//                    employeeService.viewEmployeeDetails(int empEid);
                    break;
                case 5:
                    return; // Exit the method and go back to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println();
        }
    }

    public static String selectJobIds(Scanner scanner ){
	List<String> jobIds = employeeDataAccess.getAllJobIds();

        // Print the available job_ids
        System.out.println("Available job_ids:");
        for (int i = 0; i < jobIds.size(); i++) {
            System.out.println((i + 1) + ". " + jobIds.get(i));
        }

        // Prompt the user to select a job_id
	 int selection;
    do {
        System.out.print("Enter the number corresponding to the job_id: ");
        selection = scanner.nextInt();

        if (selection < 1 || selection > jobIds.size()) {
            System.out.println("Invalid selection. Please try again.");
        }
    } while (selection < 1 || selection > jobIds.size());
    return (String) jobIds.get(selection - 1);
    
    }

    

    public static Employee showPromptsForAddEmployee(Scanner scanner){
	    
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter hire date (yyyy-MM-dd): ");
        String hireDateStr = scanner.nextLine();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date hireDate = new Date(); 
	try{

        hireDate = dateFormat.parse(hireDateStr);
	} catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.print("Enter job ID: ");
	String jobId = selectJobIds(scanner);
		

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Prompt for specific attributes based on employee type
        System.out.print("Enter employee type (R - Regular, C - Contractor, S - Sales): ");
        String employeeType = scanner.nextLine();

        double commissionPercentage = 0.0;
        if (employeeType.equalsIgnoreCase("S")) {
            System.out.print("Enter commission percentage: ");
            commissionPercentage = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
        }
	int managerId = employeeDataAccess.getRandomEmployeeId();
	int departmentId = employeeDataAccess.getRandomDepartmentId();


        // Create the employee object based on the employee type
     // Create the employee object based on the employee type
Employee employee = new RegularEmployee();
if (employeeType.startsWith(EmployeeType.REGULAR.toString().substring(0, 1))) {
    employee = EmployeeFactory.createRegularEmployee(firstName, lastName, email, phoneNumber, hireDate, jobId, salary, managerId, departmentId, EmployeeType.REGULAR);
} else if (employeeType.startsWith(EmployeeType.CONTRACTOR.toString().substring(0, 1))) {
    employee = EmployeeFactory.createContractorEmployee(firstName, lastName, email, phoneNumber, hireDate, jobId, salary, managerId, departmentId, EmployeeType.CONTRACTOR);
} else if (employeeType.startsWith(EmployeeType.SALES.toString().substring(0, 1))) {
    employee = EmployeeFactory.createSalesEmployee(firstName, lastName, email, phoneNumber, hireDate, jobId, salary, commissionPercentage, managerId, departmentId, EmployeeType.SALES);
} else {
    System.out.println("Invalid employee type. Exiting...");
}


        System.out.println("Employee created successfully:");
	return employee;
    }
    /*
    public static void payrollManagement(Scanner scanner, EmployeeDataAccess employeeDataAccess) {
        PayrollRecordService payrollService = new ImplPayrollRecordService();
        int choice;
        
        while (true) {
            System.out.println("Payroll Management");
            System.out.println("Please select an option:");
            System.out.println("1. Calculate Payroll");
            System.out.println("2. Generate Payroll Report");
            System.out.println("3. Back to Main Menu");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    payrollService.calculatePayroll();
                    break;
                case 2:
                    payrollService.generatePayrollReport();
                    break;
                case 3:
                    return; // Exit the method and go back to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println();
        }
    }
*/
}

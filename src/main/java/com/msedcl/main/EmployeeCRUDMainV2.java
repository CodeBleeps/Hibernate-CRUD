package com.msedcl.main;

import java.util.List;
import java.util.Scanner;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.service.EmployeeService;
import com.msedcl.main.service.EmployeeServiceImpl;

public class EmployeeCRUDMainV2 {

	public static void main(String[] args) {
		EmployeeService employeeService = new  EmployeeServiceImpl();  
		Scanner scanner = new Scanner(System.in);

		int employeeId, choice;
		String name, continueChoice;
		double salary;
		do {
			System.out.println("Menu :");
			System.out.println("1. Add New Employee");
			System.out.println("2. Search Employee by EmployeeId");
			System.out.println("3. Delete Employee by EmployeeId");
			System.out.println("4. Update Employee Salary by EmployeeId");
			System.out.println("5. View All Employee");
			System.out.println("6. Search by Employee Name");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 6:
				System.out.println("Enter Employee Name to be searched");
				name = scanner.next();

				List<Employee>  employeeList= employeeService.getEmployeebyEmployeeName(name);
				if(employeeList != null && !employeeList.isEmpty()) {
					System.out.println("Employees Found : ");
					employeeList.forEach(e -> System.out.println(e));
				}else {
					System.out.println("No Employees Found with such name.");
				}
				
				break;
			case 1:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				Employee employee = new Employee(0, name, salary);
				if(employeeService.addNewEmployee(employee)!= null) {
					System.out.println("New Employee Added Successfully");
					System.out.println("EmployeeId :" + employee.getEmployeeId());
				};
				break;
			case 2:
				System.out.println("Enter the employeeId :");
				employeeId = scanner.nextInt();
				Employee existingEmployee = employeeService.getEmployeebyEmployeeId(employeeId);
				if(existingEmployee!= null) {
					System.out.println("Employee Found :"+ existingEmployee);
				};
				break;
			case 3:
				System.out.println("Enter the employeeId :");
				employeeId = scanner.nextInt();
				employee = employeeService.deleteEmployeebyEmployeeId(employeeId);
				if(employee!= null) {
					System.out.println("Employee Deleted :"+ employee);
				};
				break;
			case 4:
				System.out.println("Enter the employeeId :");
				employeeId = scanner.nextInt();
				System.out.println("Enter Employee Correct Name :");
				name = scanner.next();
				System.out.println("Enter revised salary :");
				salary = scanner.nextInt();
				employee = new Employee(employeeId, name, salary);
				employee = employeeService.updateEmployee(employee);
				if(employee!= null) {
					System.out.println("Employee Updated :"+ employee);
				};
				break;
			case 5:

				employeeList= employeeService.getAllEmployees();
				if(employeeList != null && !employeeList.isEmpty()) {
					employeeList.forEach(e -> System.out.println(e));
				};
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equalsIgnoreCase("yes") || continueChoice.equalsIgnoreCase("y"));
		scanner.close();
		System.out.println("Closing Application..");

	}

}

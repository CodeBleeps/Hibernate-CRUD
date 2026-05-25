package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeCRUDMain {

	public static void main(String[] args) {

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
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				Employee employee = new Employee(0, name, salary);
				addNewEmployee(employee);
				break;
			case 2:
				System.out.println("Enter the employeeId :");
				employeeId = scanner.nextInt();
				getEmployeeByEmployeeId(employeeId);
				break;
			case 3:
				System.out.println("Enter the employeeId :");
				employeeId = scanner.nextInt();
				deleteEmployeeByEmployeeId(employeeId);
				break;
			case 4:
				System.out.println("Enter the employeeId :");
				employeeId = scanner.nextInt();
				System.out.println("Enter revised salary :");
				salary = scanner.nextInt();
				updateEmployeeSalaryByEmployeeId(employeeId, salary);
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

	public static void addNewEmployee(Employee employee) {
		// 1. Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2. Create Transaction object
		EntityTransaction entityTransaction = entityManager.getTransaction();

		// 3. Start transaction
		entityTransaction.begin();

		// 4. Save employee object into database
		entityManager.persist(employee);

		// 5. commit Transaction
		entityTransaction.commit();

		// 6. Close EntityManager
		entityManager.close();

		System.out.println("Employee Created, with employeeId = " + employee.getEmployeeId());

	}

	public static void getEmployeeByEmployeeId(int employeeId) {
		// 1. Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2. Get employee from database
		Employee employee = entityManager.find(Employee.class, employeeId);

		if (employee != null)
			System.out.println(employee);
		else
			System.out.println("Invalid EmployeeId!!");

		// 3. Close EntityManager
		entityManager.close();
	}

	public static void deleteEmployeeByEmployeeId(int employeeId) {
		// 1. Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2. Get employee from database
		Employee employee = entityManager.find(Employee.class, employeeId);		
//		Employee employee = new Employee();//entityManager.find(Employee.class, employeeId);
//		employee.setEmplyoeeId(employeeId);
//		employee.setName("Ishwar");
//		employee.setSalary(2000);

		if (employee != null) {
			System.out.println(employee);

			// 2. Create Transaction object
			EntityTransaction entityTransaction = entityManager.getTransaction();

			// 3. Start transaction
			entityTransaction.begin();

			// 4. Save employee object into database
			entityManager.remove(employee);

			// 5. commit Transaction
			entityTransaction.commit();

			// 6. Close EntityManager
			entityManager.close();

			System.out.println("Employee Deleted Successfully.");
		} else
			System.out.println("Invalid EmployeeId!!");

	}
	
	public static void updateEmployeeSalaryByEmployeeId(int employeeId, double salary) {
		//Entity States : 1.Transient  2.Persistent 3.Detached 4.Removed

		EntityManager entityManager = HibernateUtil.getEntityManager();
		Employee employee = entityManager.find(Employee.class, 7);
		
		//Employee employee = new Employee();
		//employee.setEmplyoeeId(10);
		//employee.setName("Rajeshwari");
		employee.setSalary(20000);
		
		//employee.setSalary(salary);
		//employee.setName("Ishwar");

		if (employee != null) {
			System.out.println(employee);


			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			// 4. Save/Update employee object into database
			// Values can be update by setField, persist & merge
			entityManager.persist(employee);
			//entityManager.merge(employee);
			
			//employee.setName("Ishwar Chaudhary");


			entityTransaction.commit();
			entityManager.close();

			System.out.println("Employee salary revised for employeeId = " + employee.getEmployeeId());
		} else
			System.out.println("Invalid EmployeeId!!");

	}

}

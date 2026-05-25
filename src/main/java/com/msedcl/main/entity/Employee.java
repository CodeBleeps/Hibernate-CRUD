package com.msedcl.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_details")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int EmployeeId;
	
	@Column(name = "employee_name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "salary", nullable = false)
	private double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int emplyoeeId, String name, double salary) {
		super();
		EmployeeId = emplyoeeId;
		this.name = name;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int emplyoeeId) {
		EmployeeId = emplyoeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee :[" + EmployeeId + ", name=" + name + ", salary=" + salary + "]";
	}

}

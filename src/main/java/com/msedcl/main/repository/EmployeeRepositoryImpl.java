package com.msedcl.main.repository;

import java.util.List;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	@Override
	public Employee addNewEmployee(Employee employee) {

		entityManager = HibernateUtil.getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		entityManager.close();
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		entityManager = HibernateUtil.getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		entityManager.close();
		return employee;
	}

	@Override
	public Employee getEmployeebyEmployeeId(int employeeId) {
		entityManager = HibernateUtil.getEntityManager();
		Employee employee = entityManager.find(Employee.class, employeeId);

		if (employee != null) {
			System.out.println(employee);
		} else
			System.out.println("Invalid EmployeeId!!");

		entityManager.close();
		return employee;
	}

	@Override
	public Employee deleteEmployeebyEmployeeId(int employeeId) {
		entityManager = HibernateUtil.getEntityManager();
		Employee employee = entityManager.find(Employee.class, employeeId);

		if (employee != null) {
			System.out.println(employee);

			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			entityManager.remove(employee);
			entityTransaction.commit();

			entityManager.close();

			System.out.println("Employee Deleted Successfully.");
		} else
			System.out.println("Invalid EmployeeId!!");

		entityManager.close();
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		entityManager = HibernateUtil.getEntityManager();
		String hql = "FROM Employee";
		List<Employee> employeeList = entityManager
				.createQuery(hql, Employee.class).getResultList();
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeebyEmployeeName(String name) {
		entityManager = HibernateUtil.getEntityManager();
		String hql = "FROM Employee WHERE name = :empName";
		List<Employee> employeeList = entityManager
				.createQuery(hql, Employee.class).setParameter("empName", name).getResultList();
		return employeeList;
	}

}

package com.te.ems.repository.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.ems.entity.Employee;
import com.te.ems.repository.EmsRepository;

@Repository
public class EmsRepositoryImpl implements EmsRepository {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public String register(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee.getEmpId();
	}

	@Override
	public Employee getEmployee(String empId) {
		return entityManager.find(Employee.class, empId);
	}

	@Override
	public Boolean delete(String empId) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee employee = entityManager.find(Employee.class, empId);
		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}

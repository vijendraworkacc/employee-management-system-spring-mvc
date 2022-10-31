package com.te.ems.repository;

import com.te.ems.entity.Employee;

public interface EmsRepository {
	public abstract String register(Employee employee);

	public abstract Employee getEmployee(String empId);

	public abstract Boolean delete(String empId);
}

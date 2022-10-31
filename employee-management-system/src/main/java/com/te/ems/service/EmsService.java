package com.te.ems.service;

import com.te.ems.dto.EmployeeDto;
import com.te.ems.dto.LoginDto;

public interface EmsService {
	public abstract String register(EmployeeDto employeeDto);

	public abstract Boolean checkPassword(LoginDto loginDto);

	public abstract Boolean changePassword(String empId, String oldPassword, String newPassword,
			String reEnterPassword);

	public abstract Boolean delete(String empId);
}

package com.te.ems.service.implementation;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.ems.dto.EmployeeDto;
import com.te.ems.dto.LoginDto;
import com.te.ems.entity.Employee;
import com.te.ems.repository.EmsRepository;
import com.te.ems.service.EmsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmsServiceImpl implements EmsService {

	private final EmsRepository emsRepository;

	@Override
	public String register(EmployeeDto employeeDto) {
		// Logic to the registration logic
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		// Save data using repository
		return emsRepository.register(employee);
	}

	@Override
	public Boolean checkPassword(LoginDto loginDto) {
		// Logic to check the password
		Employee employee = emsRepository.getEmployee(loginDto.getEmpId());
		return loginDto.getPassword().equals(employee.getPassword());
	}

	@Override
	public Boolean changePassword(String empId, String oldPassword, String newPassword, String reEnterPassword) {
		// Login to change password
		Employee employee = emsRepository.getEmployee(empId);
		if (oldPassword.equals(employee.getPassword()) && newPassword.equals(reEnterPassword)) {
			employee.setPassword(reEnterPassword);
			emsRepository.register(employee);
			return true;
		}
		return false;
	}

	@Override
	public Boolean delete(String empId) {
		return emsRepository.delete(empId);
	}

}

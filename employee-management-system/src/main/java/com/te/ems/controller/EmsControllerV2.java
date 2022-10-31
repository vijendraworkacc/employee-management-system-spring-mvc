package com.te.ems.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.te.ems.dto.EmployeeDto;
import com.te.ems.dto.LoginDto;
import com.te.ems.entity.Employee;
import com.te.ems.service.EmsService;

import lombok.RequiredArgsConstructor;

/*
 * This is the controller for all the dynamic files/operations
 * */

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "/dynamic")
public class EmsControllerV2 {

	private final EmsService emsService;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	/*
	 * Transferring data from login FORM to the CONTROLLER using
	 * 
	 * @ModelAttribute.
	 */
	/* READ */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute LoginDto loginDto, ModelMap map) {
		// Logic to communicate to service
		Boolean isChecked = emsService.checkPassword(loginDto);
		if (isChecked) {
			map.addAttribute("empId", loginDto.getEmpId());
			return "home";
		} else {
			map.addAttribute("message", "Login unsuccessfull!");
			return "login";
		}
	}

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	/*
	 * Transferring data from register FORM to the CONTROLLER using
	 * HttpServletRequest.
	 */
	/* CREATE */
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request) {
		String empId = request.getParameter("empId");
		String empEmail = request.getParameter("empEmail");
		int empAge = Integer.parseInt(request.getParameter("empAge"));
		String password = request.getParameter("password");

		// Logic to use service
		EmployeeDto employeeDto = EmployeeDto.builder().empAge(empAge).empEmail(empEmail).empId(empId)
				.password(password).build();
		emsService.register(employeeDto);

		return "login";
	}

	@RequestMapping(path = "/delete", method = RequestMethod.GET)
	public String delete() {
		return "delete";
	}

	/*
	 * Transferring data from delete FORM to the CONTROLLER using
	 * 
	 * @@RequestParam.
	 */
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("empId") String empId, ModelMap map) {
		// Logic to use service
		Boolean isDeleted = emsService.delete(empId);
		if (isDeleted) {
			map.addAttribute("message", "Employee is deleted!");
		} else {
			map.addAttribute("message", "Employee could not be found!");
		}
		return "delete";
	}

	@RequestMapping(path = "/changePassword", method = RequestMethod.GET)
	public String changePassword() {
		return "changePassword";
	}

	/*
	 * Transferring data from changePassword FORM to the CONTROLLER using
	 * 
	 * @RequestParam.
	 */
	/* UPDATE = READ + CREATE */
	@RequestMapping(path = "/changePassword", method = RequestMethod.POST)
	public String changePassword(@RequestParam("empId") String empId, @RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword, @RequestParam("reEnterPassword") String reEnterPassword,
			ModelMap map) {
		// Login to use service
		Boolean passwordChanged = emsService.changePassword(empId, oldPassword, newPassword, reEnterPassword);
		if (passwordChanged) {
			map.addAttribute("message", "Password change successfull!");
		} else {
			map.addAttribute("message", "Password change unsuccessfull!");
		}
		return "changePassword";
	}

	/*
	 * Transferring data from CONTROLLER to a page using Model.
	 */
	@RequestMapping(path = "/home1", method = RequestMethod.GET)
	public String home(Model model) {
		// Employee is already logged in!
		// Logic to get the data from database!
		Employee employee = Employee.builder().empAge(22).empEmail("v@v.com").empId("TY003").password("qwerty").build();
		model.addAttribute("empId", employee.getEmpId());
		model.addAttribute("empAge", employee.getEmpAge());
		model.addAttribute("empEmail", employee.getEmpEmail());
		return "home";
	}

	/*
	 * Transferring data from CONTROLLER to a page using ModelMap.
	 */
	@RequestMapping(path = "/home2", method = RequestMethod.GET)
	public String home(ModelMap modelMap) {
		// Employee is already logged in!
		// Logic to get the data from database!
		Employee employee = Employee.builder().empAge(22).empEmail("v@v.com").empId("TY003").password("qwerty").build();
		modelMap.addAttribute("empId", employee.getEmpId());
		modelMap.addAttribute("empAge", employee.getEmpAge());
		modelMap.addAttribute("empEmail", employee.getEmpEmail());
		return "home";
	}
}

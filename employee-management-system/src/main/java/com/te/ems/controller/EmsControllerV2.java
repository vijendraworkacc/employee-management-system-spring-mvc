package com.te.ems.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.te.ems.dto.LoginDto;
import com.te.ems.entity.Employee;

/*
 * This is the controller for all the dynamic files/operations
 * */
@Controller
@RequestMapping(path = "/dynamic")
public class EmsControllerV2 {

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "/WEB-INF/views/login.jsp";
	}

	/*
	 * Transferring data from login FORM to the CONTROLLER using
	 * 
	 * @ModelAttribute.
	 */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute LoginDto loginDto) {
		String empId = loginDto.getEmpId();
		String password = loginDto.getPassword();
		System.out.println(empId + " - " + password);
		return "/WEB-INF/views/login.jsp";
	}

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String register() {
		return "/WEB-INF/views/register.jsp";
	}

	/*
	 * Transferring data from register FORM to the CONTROLLER using
	 * HttpServletRequest.
	 */
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request) {
		String empId = request.getParameter("empId");
		String empEmail = request.getParameter("empEmail");
		int empAge = Integer.parseInt(request.getParameter("empAge"));
		String password = request.getParameter("password");

		System.out.println(request.getParameter("empId") + " - " + request.getParameter("empEmail") + " - "
				+ request.getParameter("empAge") + " - " + request.getParameter("password"));
		return "/WEB-INF/views/register.jsp";
	}

	@RequestMapping(path = "/delete", method = RequestMethod.GET)
	public String delete() {
		return "/WEB-INF/views/delete.jsp";
	}

	/*
	 * Transferring data from delete FORM to the CONTROLLER using
	 * 
	 * @@RequestParam.
	 */
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("empId") String empId) {
		System.out.println("Delete employee with ID: " + empId);
		return "/WEB-INF/views/delete.jsp";
	}

	@RequestMapping(path = "/changePassword", method = RequestMethod.GET)
	public String changePassword() {
		return "/WEB-INF/views/changePassword.jsp";
	}

	/*
	 * Transferring data from changePassword FORM to the CONTROLLER using
	 * 
	 * @@RequestParam.
	 */
	@RequestMapping(path = "/changePassword", method = RequestMethod.POST)
	public String changePassword(@RequestParam("empId") String empId, @RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword, @RequestParam("reEnterPassword") String reEnterPassword) {
		System.out.println(oldPassword + " - " + reEnterPassword);
		return "/WEB-INF/views/changePassword.jsp";
	}

	/*
	 * Transferring data from CONTROLLER to a .jsp page using Model.
	 */
	@RequestMapping(path = "/home1", method = RequestMethod.GET)
	public String home(Model model) {
		// Employee is already logged in!
		// Logic to get the data from database!
		Employee employee = Employee.builder().empAge(22).empEmail("v@v.com").empId("TY003").password("qwerty").build();
		model.addAttribute("empId", employee.getEmpId());
		model.addAttribute("empAge", employee.getEmpAge());
		model.addAttribute("empEmail", employee.getEmpEmail());
		return "/WEB-INF/views/home.jsp";
	}

	/*
	 * Transferring data from CONTROLLER to a .jsp page using ModelMap.
	 */
	@RequestMapping(path = "/home2", method = RequestMethod.GET)
	public String home(ModelMap modelMap) {
		// Employee is already logged in!
		// Logic to get the data from database!
		Employee employee = Employee.builder().empAge(22).empEmail("v@v.com").empId("TY003").password("qwerty").build();
		modelMap.addAttribute("empId", employee.getEmpId());
		modelMap.addAttribute("empAge", employee.getEmpAge());
		modelMap.addAttribute("empEmail", employee.getEmpEmail());
		return "/WEB-INF/views/home.jsp";
	}
}

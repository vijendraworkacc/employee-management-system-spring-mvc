package com.te.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * This is the controller for all the static files.
 * */
@Controller
@RequestMapping(path = "/static")
public class EmsControllerV1 {

	@RequestMapping(path = "/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(path = "/contact")
	public String contact() {
		return "contact";
	}
	
}

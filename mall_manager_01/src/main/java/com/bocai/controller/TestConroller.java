package com.bocai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bocai.service.TestService;

@Controller
public class TestConroller {

	@Autowired
	TestService testService;
	
	@RequestMapping("index")
	public String testIndex(){
//		int count = testService.selectCount();
		return "manager_index";
	}
}

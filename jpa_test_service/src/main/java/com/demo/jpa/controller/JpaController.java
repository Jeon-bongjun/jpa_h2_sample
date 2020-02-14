package com.demo.jpa.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jpa.model.entity.Customer;
import com.demo.jpa.service.JpaService;

@RestController
public class JpaController {

	
	@GetMapping("/test/jpa")
	public String getService(HttpServletRequest req) {
		
		String result = "";
		
		System.out.println("###################");
		
		System.out.println(req.getParameter("data"));
		
		System.out.println("###################");
		
		
		return result ; 
	}
	
	
	
	@Autowired
	JpaService jpaService;
	
	@PostMapping("/customer")
	public @ResponseBody List<Customer> createCustomer(@RequestBody Map<String,String> param){
		
		
		return jpaService.saveCust(param);
	}
	
	
}

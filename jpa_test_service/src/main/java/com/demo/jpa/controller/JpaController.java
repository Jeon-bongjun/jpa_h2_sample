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
import com.demo.jpa.model.repository.CustomerRepository;

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
	CustomerRepository customerRepository;
	
	@PostMapping("/customer")
	public @ResponseBody List<Customer> createCustomer(@RequestBody Map<String,String> param){
		String name = param.get("name");
		String phone = param.get("phone");
		Customer customer = Customer.builder().name(name).phone(phone).build();
		customerRepository.save(customer);
		
		return customerRepository.findAll();
	}
	
	
}

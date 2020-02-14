
package com.demo.jpa.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.jpa.model.entity.Customer;
import com.demo.jpa.model.repository.CustomerRepository;

@Service
public class JpaService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public @ResponseBody List<Customer> saveCust(Map<String,String> param ) {
		
		String name = param.get("name");
		String phone = param.get("phone");
		Customer customer = Customer.builder().name(name).phone(phone).build();
		customerRepository.save(customer);
		
		return customerRepository.findAll();
		
	}
	
}

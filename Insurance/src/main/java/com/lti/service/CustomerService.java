package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.lti.exception.*;
import com.lti.dao.CustomerDao;
import com.lti.entity.CustomerDetails;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	
	@Transactional
	public int register(@RequestBody CustomerDetails customer) {
		if(customerDao.isCustomerPresent(customer.getEmail()))
		    throw new InsuranceServiceException("Customer already Registered!");
		else {
		   CustomerDetails updatedCustomer=(CustomerDetails) customerDao.save(customer);
		return updatedCustomer.getId();
		
		}	
	}
	
}

package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RegisterStatus;
import com.lti.entity.CustomerDetails;
import com.lti.entity.InsurancePolicy;
import com.lti.exception.InsuranceServiceException;
import com.lti.service.PolicyService;

@RestController
@CrossOrigin
public class insurancePolicyController {

	@Autowired
	private PolicyService iservice;
	
	@RequestMapping("/policyregister.api")
	public RegisterStatus insurancePolicyRegistration(@RequestBody InsurancePolicy ipolicy) {
		try {
			int id = iservice.register(ipolicy);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(true);
			status.setRegisteredCustomerId(id);
			return status;

			// we should return some json instead
		} catch (InsuranceServiceException e) {

			RegisterStatus status = new RegisterStatus();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
	}

	
	
	
}

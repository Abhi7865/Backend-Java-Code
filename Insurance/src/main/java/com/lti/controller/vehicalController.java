package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RegisterStatus;
import com.lti.dto.vehicalRegisterStatus;
import com.lti.entity.VehicalDetail;
import com.lti.exception.InsuranceServiceException;
import com.lti.service.vehicalService;

@RestController
@CrossOrigin
public class vehicalController {

	@Autowired
	private vehicalService vService;
	
	@RequestMapping("/vehicalentry.api")
	public vehicalRegisterStatus vehicalEntry(@RequestBody VehicalDetail vehical) {
		try{
			String id=vService.register(vehical);
			vehicalRegisterStatus status = new vehicalRegisterStatus();
			status.setStatus(true);
			status.setRegisteredvehicalId(id);
			return status;
			
		}
		catch(InsuranceServiceException e) {

			vehicalRegisterStatus status = new vehicalRegisterStatus();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
			
		}
		
		
	}
}

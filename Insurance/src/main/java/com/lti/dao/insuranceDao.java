package com.lti.dao;

import org.springframework.stereotype.Component;

import com.lti.entity.CustomerDetails;
import com.lti.entity.VehicalDetail;

@Component
public class insuranceDao extends GenericDao {
	

		public boolean isPolicyPresent() {

//			return (Long) entityManager.createQuery("select count(c) from InsurancePolicy c where  c.vdetail2=: vm")
//					.setParameter("vm",vid).getSingleResult() == 1 ? true : false;
			return false;

		}

}

package com.lti.dao;

import org.springframework.stereotype.Component;

@Component
public class AdminDao extends GenericDao  {
	
	public int isValidUser(int id, String pass) {
		return (Integer) entityManager
				.createQuery("select a.id from Admin a where a.id=: id and a.password =: pw")
				.setParameter("id", id).setParameter("pw", pass).getSingleResult();

	}

}

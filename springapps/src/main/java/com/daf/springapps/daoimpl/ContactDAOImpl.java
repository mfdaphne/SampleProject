package com.daf.springapps.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daf.springapps.dao.ContactDAO;
import com.daf.springapps.dto.Contact;

@Repository("contactDAO")
@Transactional
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public Contact get(int id) {
		return sessionfactory.getCurrentSession().get(Contact.class,Integer.valueOf(id));
	}

	@Override
	public boolean add(Contact contact) {
		try {
			sessionfactory.getCurrentSession().persist(contact);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}

	}

}

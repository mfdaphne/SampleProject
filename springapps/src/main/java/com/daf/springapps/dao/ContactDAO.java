package com.daf.springapps.dao;

import java.util.List;

import com.daf.springapps.dto.Contact;


public interface ContactDAO {

//	List<Contact> list();
	Contact get(int id);
	
	boolean add(Contact contact);
	
}

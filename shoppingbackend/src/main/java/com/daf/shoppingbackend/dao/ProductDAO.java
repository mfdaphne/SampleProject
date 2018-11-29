package com.daf.shoppingbackend.dao;

import java.util.List;

import com.daf.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	
	List<Product> list();
	Product get(int id);
	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
}

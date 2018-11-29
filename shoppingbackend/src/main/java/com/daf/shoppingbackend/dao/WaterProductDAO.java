package com.daf.shoppingbackend.dao;

import java.util.List;

import com.daf.shoppingbackend.dto.WaterProduct;

public interface WaterProductDAO {

	WaterProduct get(int productId);
	List<WaterProduct> list();
	boolean add(WaterProduct wp);
	boolean update(WaterProduct wp);
	boolean delete(WaterProduct wp);
	
	List<WaterProduct> listActiveProducts();
	List<WaterProduct> getLatestActiveProducts(int count);
	
	
}

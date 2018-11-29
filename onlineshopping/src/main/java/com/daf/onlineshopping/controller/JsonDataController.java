package com.daf.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daf.shoppingbackend.dao.WaterProductDAO;
import com.daf.shoppingbackend.dto.WaterProduct;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private WaterProductDAO waterProductDAO;
	
	@RequestMapping("/orders")
	public List<WaterProduct> getAllProducts(){
		return null;
		
	}
}

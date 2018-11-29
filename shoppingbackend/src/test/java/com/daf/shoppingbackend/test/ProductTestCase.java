package com.daf.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.daf.shoppingbackend.dao.ProductDAO;
import com.daf.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.daf.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
/*	
	@Test
	public void testAddProduct() {
		
		product = new Product();
		
		product.setName("Water Can");
		product.setPrice(40);
		product.setDescription("20 L Water Can");
		product.setImageURL("CAT_4.png");
		
		assertEquals("Successfully Added a Product inside the table", true,productDAO.add(product));
	}*/
	
	@Test
	public void testUpdateProduct() {
		
		product = productDAO.get(2);
		
		product.setName("Juice");
		assertEquals("Successfully fetched single category", true,productDAO.update(product));
		
	}
	
}

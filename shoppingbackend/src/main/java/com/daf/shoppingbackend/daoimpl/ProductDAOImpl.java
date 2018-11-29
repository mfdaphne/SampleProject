package com.daf.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daf.shoppingbackend.dao.ProductDAO;
import com.daf.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Product> products = new ArrayList<>();

	/*
	 * static {
	 * 
	 * Product product = new Product();
	 * 
	 * product.setId(1); product.setName("Water Can"); product.setPrice(3000);
	 * product.setDescription("20 L Big Water Can");
	 * product.setImageURL("CAT_1.png"); products.add(product);
	 * 
	 * }
	 */

	@Override
	public List<Product> list() {
		String selectActiveProduct = "FROM Product WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	@Override
	public boolean add(Product product) {
		try {
		/*	// adding product to Database
			sessionFactory.getCurrentSession().persist(product);*/
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// Getting Single category based on ID
	@Override
	public Product get(int id) {
		//return sessionFactory.getCurrentSession().createQuery("from Foo").list();
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	/**
	 * Updating single product
	 */
	@Override
	public boolean update(Product product) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}

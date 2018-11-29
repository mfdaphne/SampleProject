package com.daf.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daf.shoppingbackend.dao.WaterProductDAO;
import com.daf.shoppingbackend.dto.WaterProduct;

@Repository("waterProductDAO")
@Transactional
public class WaterProductDAOImpl implements WaterProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public WaterProduct get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(WaterProduct.class, Integer.valueOf(productId));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<WaterProduct> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product", WaterProduct.class).getResultList();

	}

	@Override
	public boolean add(WaterProduct wp) {
		try {
			sessionFactory.getCurrentSession().persist(wp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(WaterProduct wp) {
		try {
			sessionFactory.getCurrentSession().update(wp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(WaterProduct wp) {
		try {
			wp.setActive(false);
			return this.update(wp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<WaterProduct> listActiveProducts() {
		String selectActiveProducts = "FROM PRODUCT where active = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, WaterProduct.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<WaterProduct> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM PRODUCT where active = :active order by id", WaterProduct.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}

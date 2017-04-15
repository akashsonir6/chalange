package com.niit.chalange.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chalange.Dao.ProductDao;
import com.niit.chalange.model.Product;


@Repository("productDao")
@EnableTransactionManagement

public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}

	
	

	@Transactional
	public boolean delete(String id) 
	{
		Product p = new Product();
		p.setP_id(id);
		sessionFactory.getCurrentSession().delete(p);
		return true;
	}

	@Transactional
	public Product getproduct(String id) {
		String s="from Product where P_id='" +id +"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		@SuppressWarnings("unchecked")
		List<Product> list=(List<Product>)q.list();
		if(list==null||list.isEmpty()){
		return null;
		}
		else
		{
			return list.get(0);
		}
	}
@Transactional
	public List<Product>list() {
		@SuppressWarnings("unchecked")
		List<Product> list=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}



@Transactional
public boolean delete2(Product p) {
	try {
		sessionFactory.getCurrentSession().delete(p);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}

//public Search byproduct(String name){
//	return null;
//}
}

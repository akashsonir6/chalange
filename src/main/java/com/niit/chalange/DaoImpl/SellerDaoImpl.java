package com.niit.chalange.DaoImpl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chalange.Dao.SellerDao;
import com.niit.chalange.model.Product;
import com.niit.chalange.model.Seller;


@Repository("sellerDao")
@EnableTransactionManagement

public class SellerDaoImpl implements SellerDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public SellerDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
//Save Method
@Transactional
	public boolean saveSeller(Seller  seller) {
	    sessionFactory.getCurrentSession().saveOrUpdate(seller);
	    return true;
}

//Delete method
   @Transactional
	public boolean delete(String id) 
   {
	   Seller se=new  Seller();
	   se.setId(id);
	    sessionFactory.getCurrentSession().delete(se);
		return true;
	}
 
 //Edit method
     @Transactional
     public Seller getSeller(String id)
    {
    	 String q1 ="from Seller where id='"+id+"'";
 		Query w = sessionFactory.getCurrentSession().createQuery(q1);
 		@SuppressWarnings("unchecked")
 		List<Seller> list = (List<Seller>) w.list();
 		if (list == null || list.isEmpty()) {
 			return null;
 		}
 		return list.get(0);
     }
     
//Entire list of Seller
     @Transactional 
	public List <Seller> list()
	{
		@SuppressWarnings("unchecked")
		List<Seller> sellers = (List<Seller>) sessionFactory.getCurrentSession().createCriteria(Seller.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return sellers;
	}
	
    
     
	}





package com.niit.chalange.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chalange.Dao.BillingAddressDao;
import com.niit.chalange.model.BillingAddress;
import com.niit.chalange.model.Category;


@Repository("billingAddressDao")
@EnableTransactionManagement
@Transactional
public class BillingAddressDaoImpl implements BillingAddressDao
{
	@Autowired
	SessionFactory sessionFactory;

	public BillingAddressDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean Saveorupdate(BillingAddress billingAddress)
	{
	    sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);
	    return true;
	}
	@Transactional
	public boolean delete(String billin_id)
	{
		BillingAddress b = new BillingAddress();
		b.setBillin_id(billin_id);
		sessionFactory.getCurrentSession().delete(b);
		return true;
	}
	@Transactional
	public BillingAddress get(String u_id)
	{
		String q1 ="from BillingAddress where u_id='"+u_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<BillingAddress> list = (List<BillingAddress>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	@Transactional
	public List <BillingAddress> list()
	{
		@SuppressWarnings("unchecked")
		List<BillingAddress> bill = (List<BillingAddress>) sessionFactory.getCurrentSession().createCriteria(BillingAddress.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return bill;
	}
	}



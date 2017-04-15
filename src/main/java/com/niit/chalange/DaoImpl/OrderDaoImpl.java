package com.niit.chalange.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chalange.Dao.OrderDao;
import com.niit.chalange.model.BillingAddress;
import com.niit.chalange.model.Order;

@Repository("orderDao")
@EnableTransactionManagement

public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;

	public OrderDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean Saveorupdate(Order order) {
		sessionFactory.openSession().saveOrUpdate(order);
	    return true;
	}

	@Transactional
	public boolean delete(String order_id) {
		Order o = new Order();
		o.setOrder_Id(order_id);
		sessionFactory.openSession().delete(o);
		return true;
	}

	@Transactional
	public Order get(String u_id) {
		String q1 ="from Order where u_id='"+u_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Order> list = (List<Order>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Transactional
	public List<Order> list() {
		@SuppressWarnings("unchecked")
		List<Order> order = (List<Order>) sessionFactory.getCurrentSession().createCriteria(Order.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return order;
	}

}

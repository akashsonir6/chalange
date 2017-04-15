package com.niit.chalange.DaoImpl;

import java.util.List;

import javax.persistence.Temporal;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chalange.Dao.CartItemDao;

import com.niit.chalange.model.CartItem;
@Repository("cartItemDao")
@EnableTransactionManagement
public class CartItemDaoImpl implements CartItemDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public CartItemDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory= sessionFactory;
	
	}
	
	//Save method
	@Transactional
	public boolean Save(CartItem CartItem) {
		
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(CartItem);
			
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	//Delete method
	@Transactional
	public boolean delete(String cartItem_Id) {
			CartItem ci =new CartItem();
			ci.setCartItem_Id(cartItem_Id);
			sessionFactory.getCurrentSession().delete(ci);
			return true;
		}
	
	@Transactional
	public List<CartItem> getlistbyproId(String  p_id)
	{
		String Sq= "From CartItem  where P_id='"+p_id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(Sq);
		@SuppressWarnings("unchecked")
		List<CartItem> list=(List<CartItem>) q.list();
		if(list== null || list.isEmpty()){
			return null;
		}
		else
		{
			return list;
		}
	}
	
	
    
	@Transactional
	public CartItem get(String cartItem_Id) {
		String Sq= "From CartItem  where CartItem_Id = '" +cartItem_Id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(Sq);
		@SuppressWarnings("unchecked")
		List<CartItem> list=(List<CartItem>) q.list();
		if(list== null || list.isEmpty()){
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@Transactional
	public List<CartItem> getlist(String  CartId) {
		String Sql= "from CartItem where CartId='"+CartId+"'";
		Query q1= sessionFactory.getCurrentSession().createQuery(Sql);
		@SuppressWarnings("unchecked")
		List<CartItem> list=(List<CartItem>) q1.list();
		if(list==null || list.isEmpty()){
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list;
		}
	}
	
	
	@SuppressWarnings({ "unchecked", "unused" })
	@Transactional
	public List<CartItem> list() {
		List<CartItem> list= (List<CartItem>)sessionFactory.getCurrentSession().createCriteria(CartItem.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list();
	}
	@Transactional
	public CartItem getlistall(String   CartId,String pro)
	{
		String sql= "from CartItem where CartId='" +CartId+ "'and P_id ='" +pro+ "'";
		Query q1= sessionFactory.getCurrentSession().createQuery(sql);
		@SuppressWarnings("unchecked")
		List<CartItem> list=(List<CartItem>) q1.list();
		if(list==null || list.isEmpty()){
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list.get(0);
		}
	
	
	}
	
	
	

}

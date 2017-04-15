package com.niit.chalange.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chalange.Dao.UserDao;
import com.niit.chalange.model.Authentication;
import com.niit.chalange.model.BillingAddress;
import com.niit.chalange.model.User;
@Repository("userDao")
@EnableTransactionManagement
public class UserDaoImpl implements UserDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//Save method
@Transactional	
	public boolean saveorupdate(User user)
	{
	BillingAddress b=user.getBillingAddress();
	b.setEmail(user.getU_email());
	b.setMono(user.getU_phno());
	b.setUser(user);
	
	Authentication authentication=new Authentication();
	authentication.setUsername(user.getU_email());
	sessionFactory.getCurrentSession().save(b);
	sessionFactory.getCurrentSession().save(user.getCart());
	sessionFactory.getCurrentSession().saveOrUpdate(user);
	sessionFactory.getCurrentSession().saveOrUpdate(authentication);
	
	
			return true;
	}

//Delete method
@Transactional
    public boolean delete(String id) 
    {
	   User u=new com.niit.chalange.model.User();
	 // u.setU_Id("u123");
	   
	    sessionFactory.getCurrentSession().delete(u);
		return true;
	}

//Edit list of User
@Transactional
	public User getUser(String id)
	{
		String q1="From User where u_id='"+id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<User>list =(List<User>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		   return list.get(0);
	}


@Transactional
public User getUseremail(String email)
{
	String q1="From User where u_email='"+email+"'";
	Query w = sessionFactory.getCurrentSession().createQuery(q1);
	@SuppressWarnings("unchecked")
	List<User>list =(List<User>)w.list();
	if(list==null || list.isEmpty())
	{
		return null;
	}
	   return list.get(0);
}

	
	//Entire list of User
@Transactional
	public List<User> list()
	{
		@SuppressWarnings("unchecked")
		List<User> users= (List<User>)
				sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return users;
	}

//	
	@Transactional
	 public User isValidated(String u_email,String u_psw) 
	{
		String sql= "from User where  u_email='" +u_email+ "'and u_psw ='" + u_psw + "'";
		Query q4 = sessionFactory.getCurrentSession().createQuery(sql);
		@SuppressWarnings("unchecked")
		List<User>list=(List<User>)q4.list();
		if (list==null | list.isEmpty()){
			return null;
			
		}
		
		else
		{
			return list.get(0);
		}
	}


	

}

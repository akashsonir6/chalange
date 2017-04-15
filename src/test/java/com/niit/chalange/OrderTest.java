package com.niit.chalange;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chalange.Dao.AuthenticationDao;
import com.niit.chalange.Dao.OrderDao;
import com.niit.chalange.model.Authentication;
import com.niit.chalange.model.Order;

public class OrderTest 
{
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		Order authenticationDao=(Order)context.getBean("order");
		OrderDao a=(OrderDao)context.getBean("orderDao");
		
		
		
	}
}

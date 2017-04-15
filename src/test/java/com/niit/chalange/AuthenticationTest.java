package com.niit.chalange;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chalange.Dao.AuthenticationDao;
import com.niit.chalange.model.Authentication;

public class AuthenticationTest 
{
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		AuthenticationDao authenticationDao=(AuthenticationDao)context.getBean("authenticationDao");
		Authentication a=(Authentication)context.getBean("authentication");
		
		//a.setRole_id("r78");
		a.setRole_name("adim");
		a.setUsername("dsdfs");
		
	
	if (authenticationDao.Saveorupdate(a) == true) {
		System.out.println(" Saved");

	} else {
		System.out.println(" not saved");
	}
	

}
}
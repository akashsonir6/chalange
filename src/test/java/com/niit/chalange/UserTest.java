package com.niit.chalange;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chalange.Dao.AuthenticationDao;
import com.niit.chalange.Dao.CartDao;
import com.niit.chalange.Dao.UserDao;
import com.niit.chalange.model.Authentication;
import com.niit.chalange.model.Cart;
import com.niit.chalange.model.User;



public class UserTest 
{
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		UserDao userDao=(UserDao)context.getBean("userDao");
		User u=(User)context.getBean("user");
	
		CartDao cartDao = (CartDao) context.getBean("cartDao");
		Cart cart= (Cart) context.getBean("cart");
		
		AuthenticationDao authenticationDao =(AuthenticationDao) context.getBean("authenticationDao");
		Authentication authentication= (Authentication) context.getBean("authentication");
		
		u.setU_fname("Aka");
		u.setU_lname("soni");
		u.setU_gender("male");
		u.setU_add("banglore");
		u.setU_phno("1232");
		u.setU_email("akasg@gmail.com");
		u.setU_psw("123");
		u.setRole("jsdhgj");
        u.setCart(cart);	
        
        
		// save and update
		
				if (userDao.saveorupdate(u)==true)
				{
					System.out.println("User Saved");
				
				}
				else
				{
					System.out.println("User is not saved");
				}
				
				// Delete
				
//				if(userDao.delete("USR19C7B6")==true)
//				{
//					System.out.println("User has been deleted");
//				}
//				else
//				{
//					System.out.println("User is not delete");
//				}
//				
				
//				u=(User)userDao.getUser("USR19C7B6");
//				if(u==null)
//				{
//					System.out.println("no user is found");
//				}
//				else
//				{
//					System.out.println("pro.getpro id");
//				}

		
//		 User U= userDao.isValidated("akasg@gmail.com","123");
//		  if(u==null)
//		  {
//			  System.out.println("id and pwd is not available");
//		  }
//		  else
//		  {
//			  System.out.println("id and pwd is available");
//		  }
//		  
		
		
		
		
	}	

}

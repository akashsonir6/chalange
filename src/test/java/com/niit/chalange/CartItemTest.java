package com.niit.chalange;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chalange.Dao.CartDao;
import com.niit.chalange.Dao.CartItemDao;
import com.niit.chalange.Dao.ProductDao;
import com.niit.chalange.Dao.UserDao;
import com.niit.chalange.model.Cart;
import com.niit.chalange.model.CartItem;
import com.niit.chalange.model.Product;
import com.niit.chalange.model.User;

public class CartItemTest 
{
	public static void main(String a[])
	{
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
	context.scan("com.niit.*");
	context.refresh();
	
	User user=(User)context.getBean("user");
	UserDao userDao=(UserDao)context.getBean("userDao");
	 
	Product p=(Product)context.getBean("product");  
	ProductDao productDao=(ProductDao)context.getBean("productDao"); 
	
	Cart cart=(Cart)context.getBean("cart"); 
	CartDao cartDao=(CartDao)context.getBean("cartDao");
	
	CartItem cartItem=(CartItem)context.getBean("cartItem");
	CartItemDao cartItemDao=(CartItemDao)context.getBean("cartItemDao");
	
	User u=userDao.getUser("USRCCEDFC");
	
	Product pro=(Product)productDao.getproduct("PRO3F5C03");
	
	cartItem.setCart(u.getCart());
	cartItem.setProduct(pro);
	cartItem.setPrice(pro.getPrice());
	
	if(cartItemDao.Save(cartItem)==true)
	{
		System.out.println("Cart is added");
	}
	if(cartItemDao.delete("cItem58CB15")==true)
	{
		System.out.println("Cart is deleted");
	}
	else
	{
		System.out.println("Cart is not deleted");
	}

	cart=u.getCart();
	cart.setGrandtotal(cart.getGrandtotal()+pro.getPrice());
	cart.setTotalItems(cart.getTotalItems()+1);
	cartDao.Save(cart);
   }
}

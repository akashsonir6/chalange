
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

public class CartTest 
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
	
		CartItemDao cartItemDao = (CartItemDao) context.getBean("cartItemDao");
		CartItem  CartItem=(CartItem)context.getBean("cartItem");
		
		ProductDao productDao = (ProductDao) context.getBean("productDao");
		Product  Product=(Product)context.getBean("product");
		
		
		
	User user = userDao.getUser("USR95C510");
	   
		if (user==null)
		{
			System.out.println("sorry User is not login");
		}
		else
		{		
          cart=cartDao.get(user.getCart().getCartId());
        Product  product=productDao.getproduct("PRO55A4DB");
        CartItem.setProduct(product);
          CartItem.setPrice(product.getPrice());
          CartItem.setCart(cart);
          
          cartItemDao.Save(CartItem);
          cart.setGrandtotal(cart.getGrandtotal()+product.getPrice());
          cart.setTotalItems(cart.getTotalItems());
          cartDao.Save(cart);
          
		}
		
	}
	
	

}

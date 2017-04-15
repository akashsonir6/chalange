package com.niit.chalange;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chalange.Dao.SellerDao;
import com.niit.chalange.model.Seller;

public class SellerTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		SellerDao sellerDao = (SellerDao) context.getBean("sellerDao");
		Seller se = (Seller) context.getBean("seller");
		se.setName("raj");
		se.setAdd("bangalore");
		se.setPhone("s5486541");
		// save and update
		if (sellerDao.saveSeller(se) == true) {
			System.out.println("product Saved");

		} else {
			System.out.println("product is not saved");
		}
		// Delete
		// if(categoryDao.delete("123")==true)
		// {
		// System.out.println("product has been deleted");
		// }
		// else
		// {
		// System.out.println("product is not delete");
		// }
		//
		//
		// //Pro=(Product)productDao.get("123");
		// //if(Pro==null)
		// //{
		// // System.out.println("no user is found");
		// //}
		// //else
		// //{
		// // System.out.println("pro.getpro id");
		// //}

	}
}

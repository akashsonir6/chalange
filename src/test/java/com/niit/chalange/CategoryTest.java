package com.niit.chalange;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chalange.Dao.CategoryDao;
import com.niit.chalange.model.Category;

public class CategoryTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
		Category cat = (Category) context.getBean("category");
		cat.setName("phone");
		cat.setCat("smart phone");
		// save and update
		if (categoryDao.SaveCategory(cat) == true) {
			System.out.println("cat Saved");

		} else {
			System.out.println("cat is not saved");
//		}
//		// Delete
//		// if(categoryDao.delete("123")==true)
//		// {
//		// System.out.println("product has been deleted");
//		// }
//		// else
//		// {
//		// System.out.println("product is not delete");
//		// }
//		//
//		//
//		// cat=(Category)categoryDao.getCategory("c123");
//		// if(cat==null)
//		// {
//		// System.out.println("no user is found");
//		// }
//		// else
//		// {
//		// System.out.println("pro.getpro id");
//		// 

	}

	}
}

package com.niit.chalange;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chalange.Dao.CategoryDao;
import com.niit.chalange.Dao.ProductDao;
import com.niit.chalange.Dao.SellerDao;
import com.niit.chalange.model.Category;
import com.niit.chalange.model.Product;
import com.niit.chalange.model.Seller;

public class ProductTest {

	public static void main(String a[]) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		
		context.refresh();
		ProductDao productDao = (ProductDao) context.getBean("productDao");
		Product p = (Product) context.getBean("product");

		// get the entire object of category
		CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
		Category category = (Category) context.getBean("category");

		//   the entire object of seller
		SellerDao sellerDao = (SellerDao) context.getBean("sellerDao");
		Seller seller = (Seller) context.getBean("seller");

		category = categoryDao.getCategory("CATF8C622");
		p.setCategory(category);

		seller = sellerDao.getSeller("SELR13CD94");
		p.setSeller(seller);

		p.setName("books");
		p.setDes("hdsjhf");
		p.setQue(2);
		p.setPrice(10.00f);
		// save and update
		if (productDao.saveProduct(p) == true) {
			System.out.println("product Saved");

		} else {
			System.out.println("product is not saved");
		}
		// Delete
		// if(productDao.delete("p789")==true)
		// {
		// System.out.println("product has been deleted");
		// }
		// else
		// {
		// System.out.println("product is not delete");
		// }

		Product Pro = (Product) productDao.getproduct("p789");

		if (Pro == null) {
			System.out.println("no product is found");
		} else {
			System.out.println(Pro.getP_id());
			System.out.println(Pro.getName());
			System.out.println(Pro.getDes());
			System.out.println(Pro.getQue());
			System.out.println(Pro.getPrice());
		}

		List<Product> product = productDao.list();
		for (Product pr : product) {
			System.out.println(pr.getName());
			System.out.println(pr.getPrice());
			System.out.println(pr.getQue());
			System.out.println(pr.getDes());
		}
	}

}

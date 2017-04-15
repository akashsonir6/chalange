package com.niit.chalange.Dao;

import java.util.List;

import com.niit.chalange.model.Product;


public interface ProductDao {

	public boolean saveProduct(Product Product);
	public boolean delete(String id);
	public Product getproduct(String id);
	public List<Product>list();
//	public Search Byproduct(String name);
	public boolean delete2(Product p);
}

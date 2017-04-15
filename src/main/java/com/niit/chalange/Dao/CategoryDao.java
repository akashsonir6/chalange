package com.niit.chalange.Dao;

import java.util.List;

import com.niit.chalange.model.Category;


public interface CategoryDao {

	public boolean SaveCategory(Category Category);
	public boolean delete(String id);
	public Category getCategory(String id);
	public List <Category> list();
}

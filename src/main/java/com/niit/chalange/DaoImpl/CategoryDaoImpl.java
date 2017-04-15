package com.niit.chalange.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chalange.Dao.CategoryDao;
import com.niit.chalange.model.Category;

@Repository("categoryDao")
@EnableTransactionManagement
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
	//Save method
	
	@Transactional
	public boolean SaveCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}

	
	//Delete method
	
	@Transactional
	public boolean delete(String id) {
		Category c = new Category();
		c.setId(id);
		sessionFactory.getCurrentSession().delete(c);
		return true;
	}
// Edit list of category
	@Transactional
	public Category getCategory(String id) {
		String q1 ="from Category where id='"+id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
     
	// Entire list of category
	
	@Transactional
	public List<Category> list() {
		@SuppressWarnings("unchecked")
		List<Category> categories = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return categories;
	}
}



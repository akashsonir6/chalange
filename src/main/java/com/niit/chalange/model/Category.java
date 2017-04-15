package com.niit.chalange.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Category")
@Component
public class Category {
	@SuppressWarnings("unused")
	private static final long SerialVersionUID = 1l;
	@Id
	private String id;
	@NotEmpty(message="name is mandatory")
	private String name;
	private String cat;
	@OneToMany(mappedBy = "category")
	private List<Product> product;

	public Category() {
		this.id = "CAT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public String getId() {
		
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
}
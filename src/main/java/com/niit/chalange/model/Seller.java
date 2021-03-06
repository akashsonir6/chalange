package com.niit.chalange.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Seller")
@Component
public class Seller {
	@SuppressWarnings("unused")
	private static final long SerialVersionUID = 1l;
	@Id
	private String id;
	private String name;
	private String add;
	private String phone;
	@OneToMany(mappedBy = "seller")
	private List<Product> product;

	public Seller() {
		this.id = "SELR" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

package com.niit.chalange.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Product")
@Component
public class Product {

	@SuppressWarnings("unused")
	// Auto Generation
	private static final long SerialVersionUID = 1l;
	@Id
	private String P_id;
	@ManyToOne
	@JoinColumn(name = "C_id")
	private Category category;
    @NotEmpty(message="product name is not mandetory")
	private String Name;
    @Min(value=10)
	private float price;
    @Min(value=2)
	private int Que;
	//private String image;
	@Transient
	private MultipartFile pimg;
//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}
//


	public Product() {
		P_id = "PRO" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
@NotEmpty(message="Des is not mandetory")
	private String Des;
	@ManyToOne
	@JoinColumn(name = "S_id")
	private Seller seller;

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getP_id() {
		return P_id;
	}

	public void setP_id(String p_id) {
		P_id = p_id;
	}

	public MultipartFile getPimg() {
		return pimg;
	}

	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQue() {
		return Que;
	}

	public void setQue(int que) {
		Que = que;
	}

	public String getDes() {
		return Des;
	}

	public void setDes(String des) {
		Des = des;
	}

}
package com.niit.chalange.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="User")
@Component
public class User {
	@SuppressWarnings("unused")
	private static final long SerialVersionUID = 1l;
	@Id
	private String u_Id;
	private String u_fname;
	private String u_lname;
	private String u_gender;
	private String u_add;
	private String u_phno;
	private String u_email;
	private String u_psw;
	private String role="ROLE_USER";
	@OneToOne
	@JoinColumn(name="CartId")
	private Cart cart;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billin_id")
	private BillingAddress billingAddress;
	
	public User() {
		this.u_Id ="USR"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getU_Id() {
		return u_Id;
	}
	public void setU_Id(String u_Id) {
		this.u_Id = u_Id;
	}
	
	public String getU_fname() {
		return u_fname;
	}
	public void setU_fname(String u_fname) {
		this.u_fname = u_fname;
	}
	public String getU_lname() {
		return u_lname;
	}
	public void setU_lname(String u_lname) {
		this.u_lname = u_lname;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
	public String getU_add() {
		return u_add;
	}
	public void setU_add(String u_add) {
		this.u_add = u_add;
	}
	public String getU_phno() {
		return u_phno;
	}
	public void setU_phno(String u_phno) {
		this.u_phno = u_phno;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_psw() {
		return u_psw;
	}
	public void setU_psw(String u_psw) {
		this.u_psw = u_psw;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	

				
}

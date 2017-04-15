
package com.niit.chalange.model;


import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="Orders")
@Component
public class Order {
    private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final DateFormat dtf = new SimpleDateFormat("HH:mm:ss");
	private static final long SerialVersionUID=1l;
	@Id
	private String order_Id;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "billin_id")
	BillingAddress billingAddress;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "Shippin_id")
	ShippingAddress shippingAddress;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "pay_id")
	Pay pay;
	@OneToOne
	@JoinColumn(name = "u_Id")
	User user;
	private double grand_total;
    @OneToMany(mappedBy="order")
    List<OrderItems> OrderItems;
    private String orderdate;
    private String ordertime;
	public Order() {
		Date date = new Date();
		orderdate=sdf.format(date);
		Calendar cal = Calendar.getInstance();
		Date date1 = new Date();
		ordertime=dtf.format(date1);
		this.order_Id = UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getGrand_total() {
		return grand_total;
	}

	public void setGrand_total(double grand_total) {
		this.grand_total = grand_total;
	}

	public List<OrderItems> getOrderItems() {
		return OrderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		OrderItems = orderItems;
	}

	
}


package com.cbt.coffeemanagement.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coffee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 25)
	private String productName;
	@Column(length = 25)
	private String brand;
	@Column(length = 25)
	private String roasting;
	@Column(length = 255)
	private String description;
	private int price;
	private int stockBalance;
	
	public Coffee(int id, String productName, String brand, String roasting, String description, int price,
			int stockBalance) {
		super();
		this.id = id;
		this.productName = productName;
		this.brand = brand;
		this.roasting = roasting;
		this.description = description;
		this.price = price;
		this.stockBalance = stockBalance;
	}

	public Coffee() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRoasting() {
		return roasting;
	}

	public void setRoasting(String roasting) {
		this.roasting = roasting;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStockBalance() {
		return stockBalance;
	}

	public void setStockBalance(int stockBalance) {
		this.stockBalance = stockBalance;
	}
	
	
	
}

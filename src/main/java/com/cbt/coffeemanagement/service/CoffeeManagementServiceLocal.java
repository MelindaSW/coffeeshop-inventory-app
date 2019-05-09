package com.cbt.coffeemanagement.service;

import java.util.List;

import javax.ejb.Local;

import com.cbt.coffeemanagement.domain.Coffee;

@Local
public interface CoffeeManagementServiceLocal {

public void insert(Coffee coffee);
	
	public List<Coffee> getAllCoffee();
	
	public void removeCoffee(int id);
	
	public void editCoffee(int id);
}

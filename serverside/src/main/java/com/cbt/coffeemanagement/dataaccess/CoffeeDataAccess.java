package com.cbt.coffeemanagement.dataaccess;

import java.util.List;

import javax.ejb.Local;

import com.cbt.coffeemanagement.domain.Coffee;

@Local
public interface CoffeeDataAccess {
	
	public void insert(Coffee coffee);
	
	public List<Coffee> getAllCoffee();
	
	public void removeCoffee(int id);
	
	public void editCoffee(int id);
}

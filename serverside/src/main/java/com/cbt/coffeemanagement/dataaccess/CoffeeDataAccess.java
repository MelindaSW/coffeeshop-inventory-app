package com.cbt.coffeemanagement.dataaccess;

import java.util.List;

import javax.ejb.Local;

import com.cbt.coffeemanagement.domain.Coffee;

@Local
public interface CoffeeDataAccess {
	
	public void insert(Coffee coffee);
	
	public List<Coffee> getAllCoffee() throws CoffeeNotFoundException;
	
	public List<Coffee> getCoffeeByName(String productName) throws CoffeeNotFoundException;

	public void removeCoffee(int id);
	
	public void updateCoffee(int id);

}

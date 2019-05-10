package com.cbt.coffeemanagement.service;

import java.util.List;

import javax.ejb.Local;

import com.cbt.coffeemanagement.dataaccess.CoffeeNotFoundException;
import com.cbt.coffeemanagement.domain.Coffee;

@Local
public interface CoffeeManagementServiceLocal {

public void insert(Coffee coffee);
	
	public List<Coffee> getAllCoffee() throws CoffeeNotFoundException;

	public List<Coffee> getCoffeeByName(String productName) throws CoffeeNotFoundException;
	
	public void removeCoffee(int id);
	
	public void updateCoffee(int id);


}

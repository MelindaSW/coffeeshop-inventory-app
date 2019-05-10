package com.cbt.coffeemanagement.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cbt.coffeemanagement.dataaccess.CoffeeDataAccess;
import com.cbt.coffeemanagement.dataaccess.CoffeeNotFoundException;
import com.cbt.coffeemanagement.domain.Coffee;

@Stateless
public class CoffeeManagementImplementation implements CoffeeManagementServiceLocal, CoffeeManagementService {

	@Inject
	private CoffeeDataAccess dao;
	
	@Override
	public void insert(Coffee coffee) {
		dao.insert(coffee);

	}

	@Override
	public List<Coffee> getAllCoffee() throws CoffeeNotFoundException {
		return dao.getAllCoffee();
	}

	@Override
	public List<Coffee> getCoffeeByName(String productName) throws CoffeeNotFoundException {
		return dao.getCoffeeByName(productName);
	}
	
	@Override
	public void removeCoffee(int id) {
		dao.removeCoffee(id);
	}

	@Override
	public void updateCoffee(int id) {
		dao.updateCoffee(id);
	}


}

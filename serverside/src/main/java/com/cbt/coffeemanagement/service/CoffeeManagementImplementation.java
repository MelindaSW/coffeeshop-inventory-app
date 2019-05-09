package com.cbt.coffeemanagement.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cbt.coffeemanagement.dataaccess.CoffeeDataAccess;
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
	public List<Coffee> getAllCoffee() {
		return dao.getAllCoffee();
	}

	@Override
	public void removeCoffee(int id) {
		dao.removeCoffee(id);
	}

	@Override
	public void editCoffee(int id) {
		dao.editCoffee(id);
	}

}

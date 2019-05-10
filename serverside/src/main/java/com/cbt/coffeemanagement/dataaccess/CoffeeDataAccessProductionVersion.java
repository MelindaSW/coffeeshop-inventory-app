package com.cbt.coffeemanagement.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cbt.coffeemanagement.domain.Coffee;

@Stateless
public class CoffeeDataAccessProductionVersion implements CoffeeDataAccess {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insert(Coffee newCoffee) {
		em.persist(newCoffee);

	}

	@Override
	public List<Coffee> getAllCoffee() {
		Query q = em.createQuery("select coffee from Coffee coffee");
		List<Coffee> coffee = q.getResultList();
		return coffee;
	}

	@Override
	public void removeCoffee(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editCoffee(int id) {
		// TODO Auto-generated method stub

	}

}

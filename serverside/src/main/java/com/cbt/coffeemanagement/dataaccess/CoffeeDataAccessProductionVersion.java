package com.cbt.coffeemanagement.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	public List<Coffee> getAllCoffee() throws CoffeeNotFoundException {
		Query q = em.createQuery("select coffee from Coffee coffee");
		try { 
			return q.getResultList();
		} catch (NoResultException e) {
			throw new CoffeeNotFoundException();
		}
	}

	@Override
	public List<Coffee> getCoffeeByName(String productName) throws CoffeeNotFoundException {
		String wildcard = "%" + productName + "%";
		Query q = em.createQuery("select coffee from Coffee coffee where productName like :productName");
		q.setParameter("productName", wildcard);
		try {
			return q.getResultList();
		} catch (NoResultException e) {
			throw new CoffeeNotFoundException();
		}
	}
	
	@Override
	public void removeCoffee(int id) {
		Query q = em.createQuery("delete from Coffee coffee where id= :id");
		q.setParameter("id", id);
		q.executeUpdate();
	}

	@Override
	public void updateCoffee(int id) {
		// TODO Auto-generated method stub

	}


}

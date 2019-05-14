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
		Query q = em.createQuery("SELECT coffee FROM Coffee coffee");
		try {
			return q.getResultList();
		} catch (NoResultException e) {
			throw new CoffeeNotFoundException();
		}
	}

	@Override
	public List<Coffee> getCoffeeByName(String productName) throws CoffeeNotFoundException {
		String wildcard = "%" + productName + "%";
		Query q = em.createQuery("SELECT coffee FROM Coffee coffee WHERE productName LIKE :productName");
		q.setParameter("productName", wildcard);
		try {
			return q.getResultList();
		} catch (Exception e) {
			System.err.println(e);
			throw new CoffeeNotFoundException();
		}
	}

	@Override
	public void removeCoffee(int id) throws CoffeeNotFoundException {
		Query q = em.createQuery("DELETE FROM Coffee coffee WHERE id= :id");
		q.setParameter("id", id);
		try {
			int nrOfDeletes = q.executeUpdate();
			if (nrOfDeletes < 1) {
				throw new CoffeeNotFoundException();
			}
		} catch (Exception e) {
			System.err.println(e);
			throw new CoffeeNotFoundException();
		}
	}

	@Override
	public void updateCoffee(int id, Coffee updatedCoffee) throws CoffeeNotFoundException {
		Query q = em.createQuery("UPDATE Coffee SET productName= :productName, brand= :brand, roasting= :roasting, "
				+ "description= :description, price= :price, stockBalance= :stockBalance WHERE id= :id");
		q.setParameter("id", id).setParameter("productName", updatedCoffee.getProductName())
				.setParameter("brand", updatedCoffee.getBrand())
				.setParameter("roasting", updatedCoffee.getRoasting())
				.setParameter("description", updatedCoffee.getDescription())
				.setParameter("price", updatedCoffee.getPrice())
				.setParameter("stockBalance", updatedCoffee.getStockBalance());
		try {
			int nrOfUpdates = q.executeUpdate();
			if (nrOfUpdates < 1) {
				throw new CoffeeNotFoundException();
			}
		} catch (Exception e) {
			System.err.println(e);
			throw new CoffeeNotFoundException();
		}
	}

}

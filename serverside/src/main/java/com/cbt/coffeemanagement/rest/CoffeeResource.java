package com.cbt.coffeemanagement.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.cbt.coffeemanagement.domain.Coffee;
import com.cbt.coffeemanagement.service.CoffeeManagementServiceLocal;

@Stateless
@Path("/cbt")
public class CoffeeResource {
	
	@Inject
	private CoffeeManagementServiceLocal service;
	
	@GET
	@Produces("application/JSON")
	public List<Coffee> getAllEmployees() {
		return service.getAllCoffee();
	}
	
//	@GET
//	@Produces("text/plain")
//	public String testGet() {
//		return "It works!";
//	}
	
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Response createEmployee(Coffee newCoffee) {
		try {
			service.insert(newCoffee);
			return Response.status(201).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(504).build();
		}
	}
}

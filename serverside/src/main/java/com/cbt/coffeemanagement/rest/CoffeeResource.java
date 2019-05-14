package com.cbt.coffeemanagement.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.cbt.coffeemanagement.dataaccess.CoffeeNotFoundException;
import com.cbt.coffeemanagement.domain.Coffee;
import com.cbt.coffeemanagement.service.CoffeeManagementServiceLocal;



@Stateless
@Path("/cbt")
public class CoffeeResource {
	
	@Inject
	private CoffeeManagementServiceLocal service;
	
	@GET
	@Produces("application/JSON")
	public Response getAllCoffee(@Context HttpHeaders headers) {
		System.out.println(headers.getRequestHeaders());
		try {
			List<Coffee> result = service.getAllCoffee();
			return Response.ok(result).build();
		} catch (CoffeeNotFoundException e) {
			return Response.status(404).build();
		}
	}
	
	@GET
	@Produces("application/JSON")
	@Path("{productName}") // '/' är implicit här
	public Response getCoffeeByName(@PathParam("productName") String productName, @Context HttpHeaders headers) {
		System.out.println(headers.getRequestHeaders());
		try {
			List<Coffee> result = service.getCoffeeByName(productName);
			return Response.ok(result).build();
		} catch (CoffeeNotFoundException e) {
			return Response.status(404).build();
		}
	}
	
//	@GET
//	@Produces("text/plain")
//	public String testGet() {
//		return "It works!";
//	}
	
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Response insert(Coffee newCoffee) {
		try {
			service.insert(newCoffee);
			return Response.status(201).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(504).build();
		}
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response removeCoffee(@PathParam("id") int id, @Context HttpHeaders headers) {
		System.out.println(headers.getRequestHeaders());
		try {
			service.removeCoffee(id);
			return Response.status(204).build();
		} catch (CoffeeNotFoundException e) {
			//e.printStackTrace();
			return Response.status(404).build();
		}
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes("application/JSON")
	public Response updateCoffee(@PathParam("id") int id, Coffee updatedCoffee, @Context HttpHeaders headers) {
		System.out.println(headers.getRequestHeaders());
		try {
			service.updateCoffee(id, updatedCoffee);
			return Response.status(204).build();
		} catch (CoffeeNotFoundException e) {
			//e.printStackTrace();
			return Response.status(404).build();
		}
	}
}

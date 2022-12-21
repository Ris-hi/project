package com.kcs.kcswt;


	import java.util.*;

	import jakarta.ws.rs.GET;
	import jakarta.ws.rs.POST;
	import jakarta.ws.rs.Path;
	import jakarta.ws.rs.Produces;
	import jakarta.ws.rs.core.MediaType;
	@Path("userregistration")
	public class Alienresource
	{
		UserRepository repo=new UserRepository();
		
		
		@GET
		@Produces(MediaType.APPLICATION_XML)
		
		public  List<Alien> getAlien()
		{
			System.out.println("getAlien called.......");

			
			
			return repo.getAlien(); 
		}
		@GET
		@Path("userregistration/id")
		@Produces(MediaType.APPLICATION_JSON)
		
		public  List<Alien> getAlien1()
		{
			return repo.getAlien();
		}
		@POST
		@Path("userregistration")
		public Alien CreateAlien(Alien a1)
		{
			System.out.println(a1);
			repo.create(a1); 
			
			
			return a1;
		}
	} 



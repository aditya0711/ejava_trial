/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import business.PeopleBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author samru
 */
@RequestScoped
@Path("/people")
public class PeopleResource {
    
        @EJB private PeopleBean peopleBean;

	@POST
	@Consumes("application/x-www-form-urlencoded")
        @Path("/addPeople")
	public Response post(MultivaluedMap<String, String> formData) {
 
		System.out.println(">>> name: " + formData.getFirst("name"));
                peopleBean.addPeople(formData.getFirst("name"),formData.getFirst("email"));
		return (Response.ok().build());
	}

    
}

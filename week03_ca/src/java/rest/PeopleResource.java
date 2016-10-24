/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import business.AppointmentBean;
import business.PeopleBean;
import entity.People;
import java.util.UUID;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
        @EJB private AppointmentBean appointmentBean;

	@POST
	@Consumes("application/x-www-form-urlencoded")
        public Response post(MultivaluedMap<String, String> formData) {
 
		System.out.println(">>> name: " + formData.getFirst("name"));
                
                String tid = UUID.randomUUID().toString().substring(0, 8);
                System.out.println("id"+tid);
                People people=new People();
                people.setPid(tid);
                people.setName(formData.getFirst("name"));
                people.setEmail(formData.getFirst("email"));
                peopleBean.addPeople(people);
                
		return (Response.ok().build());
	}
        
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        @Path("{email}")
        public String findByEmail(String email){
          
            String pid = peopleBean.findByEmail(email);
            return pid;
        }

    
}

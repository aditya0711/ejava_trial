/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import business.AppointmentBean;
import business.PeopleBean;
import entity.Appointment;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author samru
 */
@RequestScoped
@Path("/appointment")
public class AppointmentResource {
    
    @EJB AppointmentBean appointmentBean;
    @EJB PeopleBean peopleBean;
    List<Appointment> appointments;
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("{email}")
//    public void verifyAndReturn(@PathParam("email") String email)
//    {
//        String pid = peopleBean.verifyEmail(email);
//        if( pid != null ){
//                appointmentBean.getAllApointmentByPid(pid);
//            }
//    }
   
    
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     @Path("{email}")
    public Response getAllAppointments(@PathParam("email") String email)
    {
     //System.out.println("Inside Appt rsc find by email1" + email);

      String pid = peopleBean.findByEmail(email);
      System.out.println("Inside Appt rsc find by email2");
      appointments=appointmentBean.getAllApointment(email);
      
      JsonArrayBuilder obj=Json.createArrayBuilder();
                 for(Appointment c: appointments) 
                {
                   
                     JsonObjectBuilder objBuilder = Json.createObjectBuilder();
                
                        objBuilder.add("appointmentID",c.getApptId());
                        objBuilder.add("dateTime", c.getApptDate().toString());
                        objBuilder.add("description",c.getDescription());
                        objBuilder.add("personId",c.getPid().toString());
                        obj.add(objBuilder);
                }
                 
                 return (Response.ok(obj.build())
				.header("Powered-By", "ejava2016")
				.build());
      
    }
//    
}

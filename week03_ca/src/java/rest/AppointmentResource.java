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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
     
    public List<Appointment> getAllAppointments(@QueryParam("email") String email)
    {
      String pid= peopleBean. findByEmail(email);
      appointments=appointmentBean.getAllApointment(pid);
      
      return  appointments;            
    }
//    
}

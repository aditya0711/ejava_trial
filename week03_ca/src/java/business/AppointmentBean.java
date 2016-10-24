/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Appointment;
import entity.People;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author samru
 */
@Stateless
public class AppointmentBean {
    
     @PersistenceContext private EntityManager em;
     


     public List<Appointment> getAllApointment(String pid) {
         
     
         TypedQuery<Appointment> query =  em.createQuery("SELECT a.appointmentList FROM People a WHERE a.email=:pid",  Appointment.class);
      
   
         query.setParameter("pid",pid);
         System.out.println("query "+query.toString());
        
         
         return query.getResultList();
	
	}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Appointment;
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
     
//     public List<Appointment> getAllApointment() {
//         
//         
//		TypedQuery<Appointment> query = em.createNamedQuery(
//				"Appointment.findAll.findAll", Appointment.class);
//                
//          
//		return (query.getResultList());
//	}
     public List<Appointment> getAllApointment(String pid) {
         
       // Query q = em.createQuery("SELECT a.* FROM appointments.appointment a where a.pid =:pid");
       // q.setParameter("pid", pid);
        
         TypedQuery<Appointment> query =  em.createQuery("SELECT a FROM Appointment a,People p where  p.pid=:pid", Appointment.class);
         
         query.setParameter("pid", pid);
        
         
         return query.getResultList();
	
	}
    
}

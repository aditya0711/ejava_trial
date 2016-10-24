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
     
     public List<Appointment> getAllApointment(Integer start, Integer size) {
         
         
		TypedQuery<Appointment> query = em.createNamedQuery(
				"Appointment.findAll.findAll", Appointment.class);
                
                
		query.setFirstResult(start);
		query.setMaxResults(size);
		return (query.getResultList());
	}
    
}

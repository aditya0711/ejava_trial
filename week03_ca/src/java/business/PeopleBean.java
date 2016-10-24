/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.People;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author samru
 */
@Stateless
public class PeopleBean {
    
    @PersistenceContext private EntityManager em;
    
    public void addPeople(String name,String email)
    {
        String tid = UUID.randomUUID().toString().substring(0, 8);
        People people=new People();
        people.setPid(tid);
        people.setName(name);
        people.setEmail(email);
        
        em.persist(people);
    }
    
    
    
    
}

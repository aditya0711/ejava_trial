/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.People;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author samru
 */
@Stateless
public class PeopleBean {
    
    @PersistenceContext private EntityManager em;
    
    public void addPeople(People people)
    {
        System.out.println("name" + people.getName());
        System.out.println("name" + people.getPid());
        em.persist(people);
    }
    
    public Optional<People> findByEmail(String email){
        Query query = em.createNamedQuery("People.findByEmail");
        query.setParameter("email", email);
        People people = (People) query.getSingleResult();
        System.out.println("pid " + people.getPid());
        return (Optional.ofNullable(people));
    }
}

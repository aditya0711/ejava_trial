/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.People;
import java.util.UUID;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author samru
 */

@Named("peopleCtrl")
public class PeopleController {
        
        private String name;
        private String email;
        private Client client = ClientBuilder.newClient();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void add(){
        
        WebTarget target=client.target("http://localhost:8080/week03ca/api/people");
        
       
        
        
        
    }
    
        
        
}

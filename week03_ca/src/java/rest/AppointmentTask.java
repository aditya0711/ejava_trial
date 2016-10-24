/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author samru
 */
public class AppointmentTask implements Runnable{

    private String email;
    private Client client = ClientBuilder.newClient();
    private AsyncResponse asyncResponse;
    
    public AppointmentTask(AsyncResponse resp, String email) {
		asyncResponse = resp;
                this.email = email;
	}

    private JsonArray getAppointment(String email) {

		WebTarget target = client.target("http://localhost:8080/week03ca/api/appointment/" + email);

		Invocation.Builder inv = target.request(MediaType.APPLICATION_JSON);

		JsonArray result = inv.get(JsonArray.class);

		return (result);
    }
    
    @Override
    public void run() {
       System.out.println("====> executing in thread pool");
            JsonArray array = getAppointment(email);	
            asyncResponse.resume(Response.ok(array));
    }
    
}


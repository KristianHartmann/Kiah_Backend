package org.kiah.services;

import Entity.AnimalNoDB;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/animal")
public class AnimalDemo {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Vuf... (Message from a dog)";
    }


    @GET
    @Path("/animal_list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getList() {
        return "[\"Dog\", \"Cat\", \"Mouse\", \"Bird\"]";
    }

    @GET
    @Path("/animal")
    @Produces(MediaType.APPLICATION_JSON)
    public String getObject() {
        AnimalNoDB animalNoDB = new AnimalNoDB("Dog", "Vuf");
        return new Gson().toJson(animalNoDB);
    }


}

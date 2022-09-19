package org.kiah.services;

import DBClient.PersonController;
import DTO.PersonDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final PersonController FACADE =  PersonController.getPersonFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello Kristian :-)\"}";
    }


    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllPersons() {
        return Response.ok().entity(GSON.toJson(FACADE.getAllPersons())).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createPerson(String input){
        PersonDTO personDTO = GSON.fromJson(input, PersonDTO.class);
        PersonDTO returned = FACADE.addPerson(personDTO);
        return Response.ok().entity(GSON.toJson(returned)).build();
    }


    @SneakyThrows
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updatePerson(String input) {
        PersonDTO personDTO = GSON.fromJson(input, PersonDTO.class);
        PersonDTO returned = FACADE.editPerson(personDTO);
        return Response.ok().entity(GSON.toJson(returned)).build();
    }
    
    @Path("/update/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updatePersonPath(@PathParam("id") Integer id, String input) {
        PersonDTO personDTO = GSON.fromJson(input, PersonDTO.class);
        personDTO.setId(id);
        PersonDTO returned = FACADE.editPerson(personDTO);
        return Response.ok().entity(GSON.toJson(returned)).build();
    }


}
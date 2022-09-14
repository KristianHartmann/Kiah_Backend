package org.kiah.services;

import DBClient.EmployeeController;
import DBClient.PersonController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("employee")
public class EmployeeResource {


        private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

        private static final EmployeeController employeeController =  EmployeeController.getEmployeeFacade(EMF);
        private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


        @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllEmployees() {
        return Response.ok().entity(GSON.toJson(employeeController.getAll())).build();
    }


        @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployeeById(@PathParam("id") Long id) {
        return Response.ok().entity(GSON.toJson(employeeController.getById(id))).build();
    }



}

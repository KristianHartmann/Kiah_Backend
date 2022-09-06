package org.kiah.services;


import Controller.CustomerController;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("ordersystem")
public class OrderSystem {

    CustomerController customerController = new CustomerController();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return new Gson().toJson(customerController.getAllCustomers());
    }

}

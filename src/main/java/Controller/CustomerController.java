package Controller;

import DBClient.OrderSystemClient;
import DTO.CustomerDTO;
import Entity.OrderSystemDB.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CustomerController {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    OrderSystemClient orderSystemController = OrderSystemClient.getInstance(emf);

    public CustomerController(){
    }
    CustomerDTO customerDTO = new CustomerDTO();

    public List<Customer> getAllCustomers(){
        customerDTO.setCustomerList(orderSystemController.GetCustomers());
          return customerDTO.getCustomerList();
    }

}

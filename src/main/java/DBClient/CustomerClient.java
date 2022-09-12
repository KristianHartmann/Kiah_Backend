package DBClient;

import DTO.CustomerDTO;
import Entity.Dat3.Customer;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CustomerClient {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    OrderSystemClient orderSystemController = OrderSystemClient.getInstance(emf);

    public CustomerClient(){
    }
    CustomerDTO customerDTO = new CustomerDTO();

    public List<Customer> getAllCustomers(){
        customerDTO.setCustomerList(orderSystemController.GetCustomers());
          return customerDTO.getCustomerList();
    }

}

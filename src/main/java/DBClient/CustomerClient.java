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

    //public List<Customer> getAllCustomers(){
      //  customerDTO.setCustomerList(orderSystemController.GetCustomers());
        //  return customerDTO.getCustomerList();
    //}

    public OrderSystemClient getOrderSystemController() {
        return orderSystemController;
    }

    public void setOrderSystemController(OrderSystemClient orderSystemController) {
        this.orderSystemController = orderSystemController;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }
}

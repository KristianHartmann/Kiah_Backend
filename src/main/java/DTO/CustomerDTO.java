package DTO;

import Entity.OrderSystemDB.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CustomerDTO {
    private String Name;
private String Email;
private int id;

private List<Customer> customerList;

    public CustomerDTO(Customer customer) {
    this.Name = customer.getName();
    this.Email = customer.getEmail();
    this.id = customer.getId();
    }

    public CustomerDTO(){

    }


}

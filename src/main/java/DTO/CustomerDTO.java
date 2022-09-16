package DTO;

import Entity.Dat3.Customer;


import java.util.List;

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

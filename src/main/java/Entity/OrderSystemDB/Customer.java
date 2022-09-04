package Entity.OrderSystemDB;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table (name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCustomer", nullable = false)
    private Integer id;

    @Column(name = "Name", length = 45, nullable = false)
    private String name;

    @Column(name = "Email", length = 45, nullable = false)
    private String email;

    @OneToMany(mappedBy = "customerIdcustomer")
    private Set<Order> orders = new LinkedHashSet<>();

    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
    @Override
    public String toString()
    {
        return "Customer{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Email="  + email +
                '}';
    }

}
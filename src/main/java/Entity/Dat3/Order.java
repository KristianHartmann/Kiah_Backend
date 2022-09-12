package Entity.Dat3;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrder", nullable = false)
    private Integer id;

    @Column(name = "Created", nullable = false)
    private Date created;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Customer_idCustomer", nullable = false)
    private Customer customerIdcustomer;

    @OneToMany(mappedBy = "orderIdorder")
    private Set<OrderLine> orderLines = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order(Date created, Customer customerIdcustomer) {
        this.created = created;
        this.customerIdcustomer = customerIdcustomer;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Customer getCustomerIdcustomer() {
        return customerIdcustomer;
    }

    public void setCustomerIdcustomer(Customer customerIdcustomer) {
        this.customerIdcustomer = customerIdcustomer;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Order() {
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

}
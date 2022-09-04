package Entity.OrderSystemDB;

import javax.persistence.*;

@Entity
@Table (name = "OrderLine")
public class OrderLine {
    @Id
    @Column(name = "idOrderLine", nullable = false)
    private Integer id;

    @Column(name = "Quantity", length = 45)
    private Integer quantity;

    public OrderLine(Integer quantity, Order orderIdorder, Product productIdproduct) {
        this.quantity = quantity;
        this.orderIdorder = orderIdorder;
        this.productIdproduct = productIdproduct;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Order_idOrder", nullable = false)
    private Order orderIdorder;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Product_idProduct", nullable = false)
    private Product productIdproduct;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderLine() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrderIdorder() {
        return orderIdorder;
    }

    public void setOrderIdorder(Order orderIdorder) {
        this.orderIdorder = orderIdorder;
    }

    public Product getProductIdproduct() {
        return productIdproduct;
    }

    public void setProductIdproduct(Product productIdproduct) {
        this.productIdproduct = productIdproduct;
    }

}
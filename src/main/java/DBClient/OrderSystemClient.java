package DBClient;

import Entity.Dat3.Customer;
import Entity.Dat3.Order;
import Entity.Dat3.OrderLine;
import Entity.Dat3.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderSystemClient {


    private static OrderSystemClient instance;
    private static EntityManagerFactory emf;

    public static OrderSystemClient getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new OrderSystemClient();
        }
        return instance;
    }

    public List<Customer> GetCustomers() {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }


    public Customer GetCustomerById(int idCustomer) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, idCustomer);
    }
    public Order GetOrderById(int idOrder) {
        EntityManager em = emf.createEntityManager();
        return em.find(Order.class, idOrder);
    }


    public Product GetProductById(int idProduct) {
        EntityManager em = emf.createEntityManager();
        return em.find(Product.class, idProduct);
    }
    public OrderLine GetOrderLineById(int idOrderLine) {
        EntityManager em = emf.createEntityManager();
        return em.find(OrderLine.class, idOrderLine);
    }


    public List<Order> GetOrdersByCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Order> query = em.createQuery("Select ord from Order ord where ord.customerIdcustomer = :idCustomer", Order.class);
            query.setParameter("idCustomer", customer);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Object createEntity(Object object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();
        return object;
    }

    public Long GetPriceOnOrder(int orderid) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Long> query = em.createQuery("Select SUM(pro.price * ol.quantity) from Order ord join ord.orderLines ol join ol.productIdproduct pro where ord.id = :orderid", Long.class);
            query.setParameter("orderid", orderid);
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }
}

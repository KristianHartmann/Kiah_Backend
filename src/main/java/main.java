import Controller.OrderSystemController;
import Entity.OrderSystemDB.Customer;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class main {
    public static void main(String[] args) {
//        Point.DB
//        // Open a database connection
//        // (create a new database if it doesn't exist yet):
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//        EntityManager em = emf.createEntityManager();
//
//        // Store 1000 Point objects in the database:
//        em.getTransaction().begin();
//        for (int i = 0; i < 1000; i++) {
//            Point p = new Point(i, i);
//            em.persist(p);
//        }
//        em.getTransaction().commit();
//
//        // Find the number of Point objects in the database:
//        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
//        System.out.println("Total Points: " + q1.getSingleResult());
//
//        // Find the average X value:
//        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
//        System.out.println("Average X: " + q2.getSingleResult());
//
//        // Retrieve all the Point objects from the database:
//        TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class);
//        List<Point> results = query.getResultList();
//        for (Point p : results) {
//            System.out.println(p);
//        }

        // Close the database connection:
//        em.close();
//        emf.close();

//        Student.DB
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//        TeachingFacade teachingFacade = TeachingFacade.getInstance(emf);
//
//        List<Student> studentList = teachingFacade.getStudents();
//
//        for (Student student : studentList)
//        {
//            System.out.println(student.toString());
//        }
//
//        // Create new student
//
//        System.out.println("***** Test at vi kan oprette en ny Student i databasen:");
//        Student newStudent = teachingFacade.createStudent("Jens","Jensen");
//        System.out.println(newStudent);
//
//        emf.close();



        //OrderSystem.DB

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        OrderSystemController orderSystemController = OrderSystemController.getInstance(emf);

//        Get all customers in DB
        List<Customer> CustomerList = orderSystemController.GetCustomers();
        for (Customer customer : CustomerList)
        {
            System.out.println(customer.toString());
        }

//   Get all customers in DB
//        Customer customer = orderSystemController.GetCustomerById(1);
//        List<Order> OrderList = orderSystemController.GetOrdersByCustomer(customer);



//        Get all orders
//        for (Order order : OrderList)
//        {
//            System.out.println(order.getId());
//        }

//         Create new entity in db
//        System.out.println("***** Test at vi kan oprette en ny Entity i databasen:");
//        Customer customer = new Customer("Hess", "Hess@TEST.com");

//        Product product = new Product("Keyboard", "Steelseries", 100);
//        orderSystemController.createEntity(product);



//        Get Customer By ID
//          Customer customer = orderSystemController.GetCustomerById(2);
//          System.out.println(customer.toString());
//          emf.();

//          Get Product By ID
//          Product product = orderSystemController.GetProductById(1);
//          System.out.println(product.getName());

//
//          Get price By orderid
//          System.out.println(orderSystemController.GetPriceOnOrder(12));


//        Create order in db
//        System.out.println("***** Test at vi kan oprette en ny Order i databasen:");
//        Order order = new Order(new Date(), orderSystemController.GetCustomerById(1));
//        orderSystemController.createEntity(order);

//        Create orderline in db
//        System.out.println("***** Test at vi kan oprette en ny Order i databasen:");
//        OrderLine orderLine = new OrderLine(1, orderSystemController.GetOrderById(12), orderSystemController.GetProductById(1));
//        orderSystemController.createEntity(orderLine);
//        System.out.println(orderSystemController.GetOrderLineById(1).getQuantity());



        emf.close();

    }
}
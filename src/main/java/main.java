import Controller.TeachingFacade;

import Entity.Semester;
import Entity.Student;
import Entity.Teacher;


import javax.persistence.*;
import java.util.List;

public class main {
    public static void main(String[] args) {
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
//
//        // Close the database connection:
//        em.close();
//        emf.close();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        TeachingFacade teachingFacade = TeachingFacade.getInstance(emf);

        List<Student> studentList = teachingFacade.getStudents();

        for (Student student : studentList)
        {
            System.out.println(student.toString());
        }

        // Create new student

        System.out.println("***** Test at vi kan oprette en ny Student i databasen:");
        Student newStudent = teachingFacade.createStudent("Jens","Jensen");
        System.out.println(newStudent);

        emf.close();

    }
}
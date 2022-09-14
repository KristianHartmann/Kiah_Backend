package DBClient;

import DTO.EmployeeDTO;
import Entity.Dat3.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeController {

    private static EmployeeController instance;
    private static EntityManagerFactory emf;



        //Private Constructor to ensure Singleton
    private EmployeeController() {}


        /**
         *
         * @param _emf
         * @return an instance of this facade class.
         */
        public static EmployeeController getEmployeeFacade(EntityManagerFactory _emf) {
            if (instance == null) {
                emf = _emf;
                instance = new EmployeeController();
            }
            return instance;
        }

        private EntityManager getEntityManager() {
            return emf.createEntityManager();
        }

    public EmployeeDTO create(EmployeeDTO employeeDTO){
        Employee employeeEntity = new Employee(employeeDTO.getName(), employeeDTO.getSalary(), employeeDTO.getAddress());
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employeeEntity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new EmployeeDTO(employeeEntity);
    }

    public EmployeeDTO getById(Long id) { //throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        Employee employee = em.find(Employee.class, id);
//        if (person == null)
//            throw new PersonNotFoundException("The Person entity with ID: "+id+" Was not found");
        return new EmployeeDTO(employee);
    }

    //TODO Remove/Change this before use


    public List<EmployeeDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> employees = query.getResultList();
        return EmployeeDTO.getDtos(employees);
    }


}

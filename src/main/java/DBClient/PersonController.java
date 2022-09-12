package DBClient;

import DTO.PersonDTO;
import Entity.Dat3.Person;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonController {

    private static PersonController instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private PersonController() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonController getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonController();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PersonDTO create(PersonDTO personDTO){
        Person personEntity = new Person(personDTO.getName(), personDTO.getAge());
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(personEntity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(personEntity);
    }

    public PersonDTO getById(long id) { //throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
//        if (person == null)
//            throw new PersonNotFoundException("The Person entity with ID: "+id+" Was not found");
        return new PersonDTO(person);
    }
    
    //TODO Remove/Change this before use

    
    public List<PersonDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> persons = query.getResultList();
        return PersonDTO.getDtos(persons);
    }
    
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
//        emf = EMF_Creator.createEntityManagerFactoryForTest();
        PersonController fe = getPersonFacade(emf);
        fe.getAll().forEach(dto->System.out.println(dto));
    }

}

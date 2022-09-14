package DBClient;

import DTO.PersonDTO;
import Entity.Person;
import Interfaces.IPersonController;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonController implements IPersonController {
    Date date = new Date();

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







    
    //TODO Remove/Change this before use

    


    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
//        emf = EMF_Creator.createEntityManagerFactoryForTest();
        PersonController fe = getPersonFacade(emf);
        fe.getAllPersons().forEach(dto->System.out.println(dto));
    }

    @Override
    public PersonDTO addPerson(PersonDTO personDTO) {
        Person personEntity = new Person(personDTO.getFname(), personDTO.getLname() ,personDTO.getPhone());
        personEntity.setLastedited(date.toString());
        personEntity.setCreated(date.toString());
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

    @Override
    public boolean deletePerson(Integer id) {
        EntityManager em = getEntityManager();
        Person person = em.find(Person.class, id);
        try {
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
        }catch(Exception e){
            return false;
        } finally {
            em.close();
            return true;
        }
    }

    @Override
    public PersonDTO getPerson(Integer id) {
            EntityManager em = emf.createEntityManager();
            Person person = em.find(Person.class, id);
            if (person == null)
                return null;
            return new PersonDTO(person);
        }


    @Override
    public List<PersonDTO> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> persons = query.getResultList();
        return PersonDTO.getDtos(persons);    }

    @Override
    public PersonDTO editPerson(PersonDTO personDTO) {
        EntityManager em = getEntityManager();
        Person person = em.find(Person.class, personDTO.getId());
        if(person == null)
    return null;

        Person personEntity = new Person(personDTO.getId(), personDTO.getFname(), personDTO.getLname(), personDTO.getPhone(), personDTO.getCreated(), personDTO.getLastedited());
        personEntity.setLastedited(date.toString());
        try {
            em.getTransaction().begin();
            em.merge(personEntity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(personEntity);
    }
}

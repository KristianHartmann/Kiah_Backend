package Interfaces;

import DTO.PersonDTO;

import java.util.List;

public interface IPersonController {
    
    PersonDTO addPerson(PersonDTO personDTO);

    public boolean deletePerson(Integer id);
    public PersonDTO getPerson(Integer id);
    public List<PersonDTO> getAllPersons();
    public PersonDTO editPerson(PersonDTO p);

}

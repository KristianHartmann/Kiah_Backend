/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import DBClient.PersonController;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
//        EntityManagerFactory emftest = EMF_Creator.createEntityManagerFactoryForTest();
        PersonController fe = PersonController.getPersonFacade(emf);
//        PersonController tfe = PersonController.getPersonFacade(emftest);
//        fe.create(new PersonDTO(new Person("First 1", 1)));
//        fe.create(new PersonDTO(new Person("First 2", 2)));
//        fe.create(new PersonDTO(new Person("First 3", 3)));
//        tfe.create(new PersonDTO(new Person("First 1", 2)));
//        tfe.create(new PersonDTO(new Person("First 2", 2)));
//        tfe.create(new PersonDTO(new Person("First 3", 3)));


    }
    
    public static void main(String[] args) {
        populate();
    }
}

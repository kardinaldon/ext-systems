package service;

import dao.PersonDao;
import model.Person;

import java.util.List;

public class PersonService {

    private PersonDao personDao = new PersonDao();

    public PersonService() {
    }

    public void createPerson (Person person) {
        personDao.create(person);
    }

    public Person findPerson (int id) {
        return personDao.findById(id);
    }

    public void updatePerson (Person person) {
        personDao.update(person);
    }

    public void deletePerson (Person person) {
        personDao.delete(person);
    }

    public List <Person> findAllPerson () {
        return personDao.findAllPersons();
    }

}

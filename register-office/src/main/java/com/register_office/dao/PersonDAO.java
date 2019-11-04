package com.register_office.dao;

import com.register_office.domain.Person;

import javax.persistence.*;
import java.util.List;

public class PersonDAO {


    private EntityManager entityManager;

    public List<Person> findPersons() {
        Query query = entityManager.createNamedQuery("Person.findPersons");
        query.setParameter("personId", 1L);
        return query.getResultList();
    }

    public Long addPerson (Person person) {
        EntityTransaction tr = entityManager.getTransaction();
        tr.begin();
        try {
            entityManager.persist(person);
            entityManager.flush();
            tr.commit();
        } catch (Exception ex) {
            tr.rollback();
            throw new RuntimeException(ex);
        }

        return person.getPersonId();
    }
}

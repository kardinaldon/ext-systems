package com.register_office.dao;

import com.register_office.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonDAO {
    private EntityManager entityManager;

    public PersonDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    public List<Person> findPersons () {
        return entityManager.createQuery("select p from Person p").getResultList();
    }
}

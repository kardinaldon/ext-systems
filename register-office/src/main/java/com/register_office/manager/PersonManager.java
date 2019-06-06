package com.register_office.manager;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.register_office.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonManager {
    public static void main(String[] args) {
        sessionExample();

        jpaExample();
    }

    private static void jpaExample() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person person = new Person();
        person.setFirstName("Thomas");
        person.setLastName("Jefferson");

        em.persist(person);
        System.out.println(person.getPersonId());
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        List list = em.createQuery("FROM Person").getResultList();
        list.forEach(person3-> System.out.println(person3));

        em.close();


    }

    private static void sessionExample() {
        SessionFactory sf = buildSessionFactory();
        Session session = sf.openSession();

        session.getTransaction().begin();

        Person person = new Person();
        person.setFirstName("George");
        person.setLastName("Washington");

        Long id = (Long) session.save(person);

        session.getTransaction().commit();
        session.close();
        System.out.println(id);
        System.out.println();

        session = sf.openSession();
        Person person1 = session.get(Person.class, id);
        System.out.println(person1);
        session.close();

        session = sf.openSession();

        List<Person> list = session.createQuery("FROM Person", Person.class).list();
        list.forEach(person2-> System.out.println(person2));

        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            //ComboPooledDataSource cpds = new ComboPooledDataSource("hibernate.cfg.xml");

            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}

package com.register_office.dao;

import com.register_office.domain.Person;
import com.register_office.domain.PersonFemale;
import com.register_office.domain.PersonMale;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PersonDAOTest {

    @Test
    public void findPersons() {
        PersonDAO personDAO = new PersonDAO();
        List<Person> persons = personDAO.findPersons();
        persons.forEach(p -> {
            System.out.println("Name " + p.getFirstName());
            System.out.println("Sex " + p.getClass().getName());
            System.out.println("Passports " + p.getPassports().size());
            System.out.println("Birth Certificate " + p.getBirthCertificate());
            if (p instanceof PersonMale) {
                System.out.println("Birth Certificates " + ((PersonMale)p).getBirthCertificates().size());
                System.out.println("Marriage Certificates " + ((PersonMale)p).getMarriageCertificates().size());
            } else {
                System.out.println("Birth Certificates " + ((PersonFemale)p).getBirthCertificates().size());
                System.out.println("Marriage Certificates " + ((PersonFemale)p).getMarriageCertificates().size());
            }
            System.out.println("");
        });
    }
}
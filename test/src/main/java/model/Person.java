package model;

import javax.persistence.*;

@Entity
@Table (name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "person_surname")
    private String personSurname;

    public Person() {
    }

    public Person(String personName, String personSurname) {
        this.personName = personName;
        this.personSurname = personSurname;
    }

    public int getId() {
        return id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                ", personSurname='" + personSurname + '\'' +
                '}';
    }
}

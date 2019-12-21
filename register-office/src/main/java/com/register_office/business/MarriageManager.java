package com.register_office.business;

import com.register_office.dao.MarriageDAO;
import com.register_office.dao.PersonDAO;
import com.register_office.domain.MarriageCertificate;
import com.register_office.domain.Person;
import com.register_office.domain.PersonFemale;
import com.register_office.domain.PersonMale;
import com.register_office.view.MarriageRequest;
import com.register_office.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageManager.class);

    @Autowired
    private MarriageDAO marriageDAO;

    @Autowired
    private PersonDAO personDAO;

    @Transactional
    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("MANAGER findMarriageCertificate called");


        personDAO.addPerson(getPerson(1));
        personDAO.addPerson(getPerson(2));

        MarriageCertificate marriageCertificate = getMarriageCertificate();

        marriageDAO.saveAndFlush(marriageCertificate);

        return new MarriageResponse();
    }

    private MarriageCertificate getMarriageCertificate () {
        MarriageCertificate mc = new MarriageCertificate();
        mc.setIssueDate(LocalDate.now());
        mc.setNumber("112323213");
        mc.setActive(true);

        List<Person> persons = personDAO.findPersons();
        for (Person person : persons) {
            if (person instanceof PersonMale) {
                mc.setHusband((PersonMale)person);
            } else {
                mc.setWife((PersonFemale) person);
            }
        }
        return mc;
    }

    private Person getPerson (int sex) {
        Person p = sex == 1 ? new PersonMale() : new PersonFemale();
        p.setFirstName("1_" + sex);
        p.setLastName("2_" + sex);
        p.setPatronymic("3_" + sex);p.setDateOfBirth(LocalDate.of(1991,3,2));
        return p;
    }
}

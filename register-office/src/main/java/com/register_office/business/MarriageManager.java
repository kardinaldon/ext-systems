package com.register_office.business;

import com.register_office.dao.MarriageDAO;
import com.register_office.dao.PersonDAO;
import com.register_office.domain.MarriageCertificate;
import com.register_office.domain.Person;
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
        MarriageCertificate cert = marriageDAO.findMarriageCertificate(request);

        Person m = new PersonMale();
        m.setFirstName("1");
        m.setLastName("2");
        m.setPatronymic("3");m.setDateOfBirth(LocalDate.of(1991,3,2));
        personDAO.addPerson(m);

        return new MarriageResponse();
    }
}

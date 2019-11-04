package com.register_office.dao;

import com.register_office.domain.MarriageCertificate;
import com.register_office.view.MarriageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Component
public class MarriageDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageDAO.class);

    private EntityManager entityManager;
    @Value("${test.value}")
    private String test;

    public void setTest(String test) {
        this.test = test;
    }

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called:{}", test);
        return null;
    }
}

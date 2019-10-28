package com.register_office.dao;

import com.register_office.domain.MarriageCertificate;
import com.register_office.view.MarriageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MarriageDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageDAO.class);
    private EntityManager entityManager;

    // TODO: 28.10.19 test field with set
    private String test;
    public void setTest(String test) {
        this.test = test;
    }

    public MarriageDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    public MarriageCertificate findMarriageCertificate (MarriageRequest marriageRequest) {
        LOGGER.info("DAO findMarriageCertificate findMarriageCertificate called :{}", test);
        Query query = entityManager.createNamedQuery("MarriageCertificate.findCertificates");
        return  null;
    }
}

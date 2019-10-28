package com.register_office.business;

import com.register_office.dao.MarriageDAO;
import com.register_office.domain.MarriageCertificate;
import com.register_office.rest.MarriageController;
import com.register_office.view.MarriageRequest;
import com.register_office.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarriageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageManager.class);

    private MarriageDAO marriageDAO;


    public void setMarriageDAO(MarriageDAO marriageDAO) {
        this.marriageDAO = marriageDAO;
    }

    public MarriageResponse findMarriageCertificate (MarriageRequest request) {
        LOGGER.info("MANAGER findMarriageCertificate called");
        MarriageCertificate cert = marriageDAO.findMarriageCertificate(request);

        return new MarriageResponse();
    }
}

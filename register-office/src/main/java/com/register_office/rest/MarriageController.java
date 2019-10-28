package com.register_office.rest;

import com.register_office.business.MarriageManager;
import com.register_office.view.MarriageRequest;
import com.register_office.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarriageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageController.class);
    private MarriageManager marriageManager;
    public void setMarriageManager(MarriageManager marriageManager) {
        this.marriageManager = marriageManager;
    }

    public MarriageResponse findMarriageCertificate (MarriageRequest marriageRequest) {
        LOGGER.info("findMarriageCertificate called");
        return marriageManager.findMarriageCertificate(marriageRequest);
    }
}

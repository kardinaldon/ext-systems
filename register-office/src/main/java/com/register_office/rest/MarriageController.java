package com.register_office.rest;

import com.register_office.business.MarriageManager;
import com.register_office.view.MarriageRequest;
import com.register_office.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("controller")
public class MarriageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageController.class);

    @Autowired
    @Qualifier("marriageService")
    private MarriageManager marriageManager;

    public MarriageResponse findMarriageCertificate (MarriageRequest marriageRequest) {
        LOGGER.info("findMarriageCertificate called");
        return marriageManager.findMarriageCertificate(marriageRequest);
    }
}

package com.cityregister.web;

import com.cityregister.dao.PersonCheckDao;
import com.cityregister.dao.PoolConnectionBuilder;
import com.cityregister.domain.PersonRequest;
import com.cityregister.domain.PersonResponse;
import com.cityregister.exception.PersonCheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/check")
@Singleton
public class CheckPersonService {


    private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);

    private PersonCheckDao dao;

    @PostConstruct
    public void init () {
        logger.info("START");
        dao= new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson (PersonRequest request) throws PersonCheckException {

        logger.info(request.toString());

        return dao.checkPerson(request);
    }
}

package com.cityregister.web;

import com.cityregister.dao.PersonCheckDao;
import com.cityregister.dao.PoolConnectionBuilder;
import com.cityregister.domain.PersonRequest;
import com.cityregister.domain.PersonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


@WebServlet (name = "CheckPersonServlet", urlPatterns = "/checkPerson")
public class CheckPersonServlet extends HttpServlet {
    private PersonCheckDao dao;
    private static final Logger logger = LoggerFactory.getLogger(CheckPersonServlet.class);

    @Override
    public void init() throws ServletException {
        logger.info("servlet created");
        dao= new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String surname = req.getParameter("surname");

        PersonRequest pr = new PersonRequest();
        pr.setSurName(surname);
        pr.setGivenName("Павел");
        pr.setPatronymic("Николаевич");
        pr.setDateOfBirth(LocalDate.of(1995,3,18));
        pr.setStreetCode(1);
        pr.setBuilding("10");
        pr.setExtension("2");
        pr.setApartment("121");


        try {
            PersonResponse ps = dao.checkPerson(pr);
            if (ps.isRegister()) {
                resp.getWriter().write("Register");
            } else {
                resp.getWriter().write("Not Register");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

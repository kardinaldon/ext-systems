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
import java.time.format.DateTimeFormatter;


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

        PersonRequest pr = new PersonRequest();
        pr.setSurName(req.getParameter("surname"));
        pr.setGivenName(req.getParameter("givenname"));
        pr.setPatronymic(req.getParameter("patronymic"));
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        pr.setDateOfBirth(dateOfBirth);
        pr.setStreetCode(Integer.parseInt(req.getParameter("streetCode")));
        pr.setBuilding(req.getParameter("building"));
        pr.setExtension(req.getParameter("extension"));
        pr.setApartment(req.getParameter("apartment"));


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

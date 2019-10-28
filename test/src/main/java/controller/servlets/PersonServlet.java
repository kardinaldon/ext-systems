package controller.servlets;

import model.Person;
import service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class PersonServlet extends HttpServlet {

    private PersonService personService = new PersonService();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List <Person> personList = personService.findAllPerson();
        req.setAttribute("persons",personList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/showUsers.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surName = req.getParameter("surname");
        Person person = new Person(name,surName);
        personService.createPerson(person);
        resp.sendRedirect("http://localhost:8080/testcrud_1_war/persons");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Person person = personService.findPerson(id);
        person.setPersonName(req.getParameter("name"));
        person.setPersonSurname(req.getParameter("surname"));
        personService.updatePerson(person);
        resp.sendRedirect("http://localhost:8080/testcrud_1_war/persons");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        personService.deletePerson(personService.findPerson(id));
        resp.sendRedirect("http://localhost:8080/testcrud_1_war/persons");
    }
}

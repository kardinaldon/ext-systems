package edu.project.student_order.validators.register;

import edu.project.student_order.domain.register.CityRegisterRequest;
import edu.project.student_order.domain.register.CityRegisterResponse;
import edu.project.student_order.domain.Person;
import edu.project.student_order.exception.CityRegisterException;
import edu.project.student_order.exception.TransportException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class RealCityRegisterChecker implements CityRegisterChecker {
    public CityRegisterResponse checkPerson (Person person) throws CityRegisterException, TransportException {

        CityRegisterRequest request = new CityRegisterRequest(person);

        Client client = ClientBuilder.newClient();
        CityRegisterResponse response = client.target("http://localhost:8080/city-register-1.0/rest/check")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON))
                .readEntity(CityRegisterResponse.class);

        return response;
    }
}

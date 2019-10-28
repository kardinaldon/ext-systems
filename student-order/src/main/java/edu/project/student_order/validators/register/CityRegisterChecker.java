package edu.project.student_order.validators.register;

import edu.project.student_order.domain.register.CityRegisterResponse;
import edu.project.student_order.domain.Person;
import edu.project.student_order.exception.CityRegisterException;
import edu.project.student_order.exception.TransportException;

public interface CityRegisterChecker {
    CityRegisterResponse checkPerson (Person person) throws CityRegisterException, TransportException;
}

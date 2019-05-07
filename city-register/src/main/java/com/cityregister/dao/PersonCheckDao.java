package com.cityregister.dao;

import com.cityregister.domain.PersonRequest;
import com.cityregister.domain.PersonResponse;
import com.cityregister.exception.PersonCheckException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCheckDao {
    private static final String SQL_REQUEST="select temporal from cr_address_person ap " +
            "inner join cr_person p on p.person_id = ap.person_id " +
            "inner join cr_address a on a.address_id = ap.address_id " +
            "where " +
            "p.sur_name = ? and p.given_name=? and p.patronymic=? and p.date_of_birth=? " +
            "and a.street_code=? and a.building=? and a.extension=? and a.apartment=?;";
    public PersonResponse checkPerson (PersonRequest request) throws PersonCheckException {
        PersonResponse response = new PersonResponse();

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(SQL_REQUEST)) {

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                response.setRegister(true);
                response.setTemporal(rs.getBoolean("temporal"));
            }
        } catch (SQLException ex) {
            throw new PersonCheckException(ex);
        }

        return response;
    }

    private Connection getConnection() {
        return null;
    }
}

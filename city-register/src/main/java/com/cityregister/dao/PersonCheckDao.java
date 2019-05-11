package com.cityregister.dao;

import com.cityregister.domain.PersonRequest;
import com.cityregister.domain.PersonResponse;
import com.cityregister.exception.PersonCheckException;

import java.sql.*;

public class PersonCheckDao {
    private static final String SQL_REQUEST="select temporal from cr_address_person ap " +
            "inner join cr_person p on p.person_id = ap.person_id " +
            "inner join cr_address a on a.address_id = ap.address_id " +
            "where " +
            "current_date >= ap.start_date and (current_date <= ap.end_date or ap.end_date is null )" +
            "and p.sur_name = ? and p.given_name=? and p.patronymic=? and p.date_of_birth=? " +
            "and a.street_code=? and a.building=? ";


    public PersonCheckDao() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public PersonResponse checkPerson (PersonRequest request) throws PersonCheckException {
        PersonResponse response = new PersonResponse();

        String sql = SQL_REQUEST;

        if (request.getExtension() != null) {
            sql+="and a.extension=? ";
        } else {
            sql+="and a.extension is null ";
        }

        if (request.getApartment() != null) {
            sql+="and a.apartment=? ";
        } else {
            sql+="and a.apartment is null ";
        }

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            int count = 1;
            stmt.setString(count++,request.getSurName());
            stmt.setString(count++,request.getGivenName());
            stmt.setString(count++,request.getPatronymic());
            stmt.setDate(count++,java.sql.Date.valueOf(request.getDateOfBirth()));
            stmt.setInt(count++,request.getStreetCode());
            stmt.setString(count++,request.getBuilding());
            if(request.getExtension()!=null) {
                stmt.setString(count++, request.getExtension());
            }
            if (request.getApartment()!=null) {
                stmt.setString(count++, request.getApartment());
            }
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

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/city_register","postgres","123456789");
    }
}

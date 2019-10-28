package edu.project.student_order.dao;

import edu.project.student_order.config.Config;
import edu.project.student_order.domain.CountryArea;
import edu.project.student_order.domain.PassportOffice;
import edu.project.student_order.domain.RegisterOffice;
import edu.project.student_order.domain.Street;
import edu.project.student_order.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryDaoImpl.class);

    private static final String GET_STREET = "select street_code, street_name from js_street where upper (street_name) like upper(?)";
    private static final String GET_PASSPORT = "select * from js_passport_office where p_office_area_id = ?";
    private static final String GET_REGISTER = "select * from js_register_office where r_office_area_id = ?";
    private static final String GET_AREA = "select * from js_country_struct where area_id like ? and area_id <> ?";

    private Connection getConnection () throws SQLException {
        return ConnectionBuilder.getConnection();
    }
    @Override
    public List <Street> findStreets (String pattern) throws DaoException {
        List<Street> result = new LinkedList<>();

        try (Connection con = getConnection();PreparedStatement stmt = con.prepareStatement(GET_STREET)) {
            stmt.setString(1,"%"+pattern+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
                result.add(str);
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage(),ex);
            throw new DaoException(ex);
        }
        return result;
    }

    @Override
    public List<PassportOffice> findPassportOffices(String areaId) throws DaoException {
        List<PassportOffice> result = new LinkedList<>();

        try (Connection con = getConnection();PreparedStatement stmt = con.prepareStatement(GET_PASSPORT)) {
            stmt.setString(1,areaId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PassportOffice str = new PassportOffice(rs.getLong("p_office_id"), rs.getString("p_office_area_id"), rs.getString("p_office_name"));
                result.add(str);
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage(),ex);
            throw new DaoException(ex);
        }
        return result;
    }

    @Override
    public List<RegisterOffice> findRegisterOffices(String areaId) throws DaoException {
        List<RegisterOffice> result = new LinkedList<>();

        try (Connection con = getConnection();PreparedStatement stmt = con.prepareStatement(GET_REGISTER)) {
            stmt.setString(1,areaId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RegisterOffice str = new RegisterOffice(rs.getLong("r_office_id"), rs.getString("r_office_area_id"), rs.getString("r_office_name"));
                result.add(str);
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage(),ex);
            throw new DaoException(ex);
        }
        return result;
    }

    @Override
    public List<CountryArea> findAreas(String areaId) throws DaoException {
        List<CountryArea> result = new LinkedList<>();

        try (Connection con = getConnection();PreparedStatement stmt = con.prepareStatement(GET_AREA)) {
            String param1 =buildParam(areaId);
            String param2 =areaId;
            stmt.setString(1,param1);
            stmt.setString(2,param2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CountryArea str = new CountryArea(rs.getString("area_id"), rs.getString("area_name"));
                result.add(str);
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage(),ex);
            throw new DaoException(ex);
        }
        return result;
    }

    private String buildParam(String areaId) throws SQLException {
        if(areaId==null || areaId.trim().isEmpty()){
            return "__0000000000";
        } else if (areaId.endsWith("0000000000")) {
            return areaId.substring(0,2)+"__0000000";
        } else if (areaId.endsWith("0000000")){
            return areaId.substring(0,5)+"___0000";
        } else if (areaId.endsWith("0000")){
            return areaId.substring(0,8)+"____";
        }
        throw  new SQLException("invalid parametr aria ID"+ areaId);
    }
}

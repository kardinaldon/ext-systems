package edu.project.student_order.dao;

import edu.project.student_order.domain.StudentOrder;
import edu.project.student_order.exception.DaoException;

import java.util.List;

public interface StudentOrderDao {
    Long saveStudentOrder (StudentOrder so) throws DaoException;

    List<StudentOrder> getStudentOrders () throws DaoException;
}

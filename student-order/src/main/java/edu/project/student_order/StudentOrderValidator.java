package edu.project.student_order;

import edu.project.student_order.dao.StudentOrderDaoImpl;
import edu.project.student_order.domain.*;
import edu.project.student_order.domain.children.AnswerChildren;
import edu.project.student_order.domain.register.AnswerCityRegister;
import edu.project.student_order.domain.student.AnswerStudent;
import edu.project.student_order.domain.wedding.AnswerWedding;
import edu.project.student_order.exception.DaoException;
import edu.project.student_order.mail.MailSendler;
import edu.project.student_order.validators.ChildrenValidator;
import edu.project.student_order.validators.CityRegisterValidator;
import edu.project.student_order.validators.StudentValidator;
import edu.project.student_order.validators.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {
    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSendler mailSendler;

    public StudentOrderValidator () {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSendler = new MailSendler();
    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }
    public void checkAll () {
        try {
            List<StudentOrder> soList = readStudentOrders();
            for (StudentOrder so : soList) {
                System.out.println();
                checkOneOrder(so);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<StudentOrder> readStudentOrders() throws DaoException {
        return new StudentOrderDaoImpl().getStudentOrders();
    }
    public void checkOneOrder (StudentOrder so) {
        AnswerCityRegister answerCityRegister = checkCityRegister(so);
//        AnswerWedding answerWedding = checkWedding(so);
//        AnswerChildren answerChildren = checkChildren(so);
//        AnswerStudent answerStudent = checkStudent(so);
//        sendMail(so);
    }



    public AnswerCityRegister checkCityRegister (StudentOrder so) {
        return cityRegisterVal.checkCityRegister(so);
    }
    public AnswerWedding checkWedding (StudentOrder so) {
        return weddingVal.checkWedding(so);
    }
    public AnswerChildren checkChildren (StudentOrder so) {
        return childrenVal.checkChildren(so);
    }
    public AnswerStudent checkStudent (StudentOrder so) {
        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so) {
        mailSendler.sendMail(so);
    }
}

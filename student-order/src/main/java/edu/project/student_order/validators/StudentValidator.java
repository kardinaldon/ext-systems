package edu.project.student_order.validators;

import edu.project.student_order.domain.student.AnswerStudent;
import edu.project.student_order.domain.StudentOrder;

public class StudentValidator {
    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("check student");
        return new AnswerStudent();
    }
}

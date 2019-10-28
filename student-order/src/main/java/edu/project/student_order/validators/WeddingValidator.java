package edu.project.student_order.validators;

import edu.project.student_order.domain.wedding.AnswerWedding;
import edu.project.student_order.domain.StudentOrder;

public class WeddingValidator {
    public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("check wedding");
        return new AnswerWedding();
    }
}

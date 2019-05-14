package edu.project.student_order.validators;

import edu.project.student_order.domain.children.AnswerChildren;
import edu.project.student_order.domain.StudentOrder;

public class ChildrenValidator {
    public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("check children");
        return new AnswerChildren();
    }
}

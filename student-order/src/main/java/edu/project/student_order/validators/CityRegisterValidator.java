package edu.project.student_order.validators;

import edu.project.student_order.domain.Person;
import edu.project.student_order.domain.register.AnswerCityRegister;
import edu.project.student_order.domain.Child;
import edu.project.student_order.domain.register.AnswerCityRegisterItem;
import edu.project.student_order.domain.register.CityRegisterResponse;
import edu.project.student_order.domain.StudentOrder;
import edu.project.student_order.exception.CityRegisterException;
import edu.project.student_order.exception.TransportException;
import edu.project.student_order.validators.register.CityRegisterChecker;
import edu.project.student_order.validators.register.RealCityRegisterChecker;

import java.util.List;

public class CityRegisterValidator {
    private static final String IN_CODE = "NO GRN";
    public String hostName;
    public String login;
    public String password;

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new RealCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
            AnswerCityRegister ans = new AnswerCityRegister();
            ans.addItem(checkPerson(so.getHusband()));
            ans.addItem(checkPerson(so.getWife()));

            List <Child> children = so.getChildren();
//            for (int i = 0; i < so.getChildren().size(); i++) {
//                CityRegisterResponse cans = personChecker.checkPerson(children.get(i));
//            }
//            for (Iterator <Child> it = children.iterator(); it.hasNext();) {
//                Child child=it.next();
//                CityRegisterResponse cans = personChecker.checkPerson(child);
//            }
            for (Child child: children) {
                ans.addItem(checkPerson(child));
            }
        return ans;
    }
    private AnswerCityRegisterItem checkPerson (Person person) {
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;
        try {
            CityRegisterResponse tmp = personChecker.checkPerson(person);
            status=tmp.isRegistered()?AnswerCityRegisterItem.CityStatus.YES:AnswerCityRegisterItem.CityStatus.NO;
            }
         catch (CityRegisterException e) {
            e.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(e.getCode(),e.getMessage());
        } catch (TransportException te) {
            te.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE,te.getMessage());

        }

        AnswerCityRegisterItem ans = new AnswerCityRegisterItem(status, person, error);

        return ans;
    }
}


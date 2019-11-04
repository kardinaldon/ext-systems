package com.register_office;

import com.register_office.rest.MarriageController;
import com.register_office.view.MarriageRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"springContext.xml"}
        );
//        MarriageController controller = applicationContext.getBean(MarriageController.class);
        MarriageController controller = applicationContext.getBean("controller", MarriageController.class);
        controller.findMarriageCertificate(new MarriageRequest());
    }
}

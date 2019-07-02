import model.Person;
import service.PersonService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
//        int [] a = {2,3,12,53,23,12,34};
//        System.out.println(Arrays.toString(a));
//        Scanner sc = new Scanner(System.in);
//        if(sc.hasNextBigInteger()) {
//            BigInteger bi = sc.nextBigInteger();
//            System.out.println("Big Integer "+bi);
//        } else if (sc.hasNextBigDecimal()) {
//            BigDecimal bd = sc.nextBigDecimal();
//            System.out.println("Big Decimal "+bd);
//        } else if (sc.hasNext()) {
//            String string = sc.next();
//            System.out.println("String "+string);
//        }
//        PersonService personService = new PersonService();
//        Person person = new Person("Iren", "Teyler");
//        personService.createPerson(person);

//        PersonService personService = new PersonService();
//        List <Person> personList = personService.findAllPerson();
//        System.out.println(personList.size());
//        System.out.println(personList.toString());

        PersonService personService = new PersonService();
        personService.deletePerson(personService.findPerson(18));

    }
}

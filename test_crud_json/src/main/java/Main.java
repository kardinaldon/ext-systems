import entity.CurrencyData;
import entity.MainData;
import services.DataService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {


        CurrencyData aud = new CurrencyData();
        aud.setId("R01010");
        aud.setNumCode("R01010");
        aud.setCharCode("AUD");
        aud.setNominal("1");
        aud.setShortName("Австралийский доллар");
        aud.setValue("44.9951");
        aud.setPreviousValue("44.8043");

        CurrencyData azn = new CurrencyData();
        aud.setId("R01020A");
        aud.setNumCode("944");
        aud.setCharCode("AZN");
        aud.setNominal("1");
        aud.setShortName("Азербайджанский манат");
        aud.setValue("39.4384");
        aud.setPreviousValue("39.2711");

        List <CurrencyData> currencyDataList = new ArrayList();
        currencyDataList.add(aud);
        currencyDataList.add(azn);

        DataService dataService = new DataService();
        MainData mainData = new MainData("2019-09-04T11:30:00+03:00","2019-09-03T11:30:00+03:00","//www.cbr-xml-daily.ru/archive/2019/09/03/daily_json.js",
                "2019-09-03T19:00:00+03:00",currencyDataList);
        dataService.saveUser(mainData);











//        mainData.addAuto(ferrari);
//        Auto ford = new Auto("Ford", "black");
//        ford.setUser(user);
//        user.addAuto(ford);
//        userService.updateUser(user);
    }
}

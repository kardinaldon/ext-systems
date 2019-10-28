package JSONParser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.MainInputValues;
import model.ValuteInputValues;

import java.io.*;
import java.net.URL;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JSONParser {
    public static void main(String[] args)
    {
        String result;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        try
        {
            BufferedReader br;
            MainInputValues mainInputValues;

                URL url = new URL("https://www.cbr-xml-daily.ru/daily_json.js");
                InputStream is = url.openStream();
                br = new BufferedReader(new InputStreamReader(is));

                mainInputValues = mapper.readValue(br, MainInputValues.class);


            System.out.println("*** Currency Details ***");
            System.out.println("Date : "+mainInputValues.getData());
            System.out.println("PreviousDate : "+mainInputValues.getPreviousDate());
            System.out.println("PreviousURL : "+mainInputValues.getPreviousURL());
            System.out.println("Timestamp  : "+mainInputValues.getTimestamp());
            System.out.println("Currency : " +mainInputValues.getValute());
            for(ValuteInputValues val : mainInputValues.getValute())
            {
                System.out.println(val.getId());
                System.out.println(val.getNominal());
            }
            br.close();
            is.close();
        } catch (JsonParseException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

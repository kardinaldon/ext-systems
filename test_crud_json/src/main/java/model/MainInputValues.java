package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

@JsonAutoDetect
public class MainInputValues {

    String data;
    String previousDate;
    String previousURL;
    String timestamp;
    List <ValuteInputValues> valute;


    public MainInputValues() {
    }

    public MainInputValues(@JsonProperty(value = "Date") String data, @JsonProperty(value = "PreviousDate") String previousDate,
                           @JsonProperty(value = "PreviousURL") String previousURL, @JsonProperty(value = "Timestamp") String timestamp,
                           @JsonProperty(value = "Valute") List <ValuteInputValues> valute){
        //String data, String previousDate, String previousURL, String timestamp, List<ValuteInputValues> valute

        this.data = data;
        this.previousDate = previousDate;
        this.previousURL = previousURL;
        this.timestamp = timestamp;
        this.valute = valute;
    }

    @JsonGetter("Data")
    public String getData() {
        return data;
    }

    @JsonSetter("Data")
    public void setData(String data) {
        this.data = data;
    }

    @JsonGetter("PreviousDate")
    public String getPreviousDate() {
        return previousDate;
    }

    @JsonSetter("PreviousDate")
    public void setPreviousDate(String previousDate) {
        this.previousDate = previousDate;
    }

    @JsonGetter("PreviousURL")
    public String getPreviousURL() {
        return previousURL;
    }

    @JsonSetter("PreviousURL")
    public void setPreviousURL(String previousURL) {
        this.previousURL = previousURL;
    }

    @JsonGetter("Timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonSetter("Timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List <ValuteInputValues> getValute() {
        return valute;
    }

    public void setValute(List <ValuteInputValues> valute) {
        this.valute = valute;
    }

    @Override
    public String toString() {
        return "MainInputValues{" +
                "data='" + data + '\'' +
                ", previousDate='" + previousDate + '\'' +
                ", previousURL='" + previousURL + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", valute=" + valute +
                '}';
    }
}

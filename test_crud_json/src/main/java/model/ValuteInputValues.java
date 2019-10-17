package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
public class ValuteInputValues {
    //String valuteName;
    String id;
    String numCode;
    String charCode;
    String nominal;
    String shortName;
    String value;
    String previousValue;

    public ValuteInputValues() {
    }

    public ValuteInputValues(
            @JsonProperty(value = "ID") String id, @JsonProperty(value = "NumCode") String numCode, @JsonProperty(value = "CharCode") String charCode,
            @JsonProperty(value = "Nominal") String nominal, @JsonProperty(value = "Name") String shortName, @JsonProperty(value = "Value") String value,
            @JsonProperty(value = "Previous") String previousValue
        ) {
            //String id, String numCode, String charCode, String nominal, String shortName, String value, String previousValue
        //this.valuteName = valuteName;
        this.id = id;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.shortName = shortName;
        this.value = value;
        this.previousValue = previousValue;
    }

//    public String getValuteName() {
//        return valuteName;
//    }
//
//    public void setValuteName(String valuteName) {
//        this.valuteName = valuteName;
//    }

    @JsonGetter("ID")
    public String getId() {
        return id;
    }

    @JsonSetter("ID")
    public void setId(String id) {
        this.id = id;
    }

    @JsonGetter("NumCode")
    public String getNumCode() {
        return numCode;
    }

    @JsonSetter("NumCode")
    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    @JsonGetter("CharCode")
    public String getCharCode() {
        return charCode;
    }

    @JsonSetter("CharCode")
    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    @JsonGetter("Nominal")
    public String getNominal() {
        return nominal;
    }

    @JsonSetter("Nominal")
    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    @JsonGetter("Name")
    public String getShortName() {
        return shortName;
    }

    @JsonSetter("Name")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonGetter("Value")
    public String getValue() {
        return value;
    }

    @JsonSetter("Value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonGetter("Previous")
    public String getPreviousValue() {
        return previousValue;
    }

    @JsonSetter("Previous")
    public void setPreviousValue(String previousValue) {
        this.previousValue = previousValue;
    }
}

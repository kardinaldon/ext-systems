package entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "currency_data")
public class CurrencyData {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_name")
    MainData name_of_currency;

    @Id
    @Column(name = "id")
    String id;

    @Column(name = "numCode")
    String numCode;

    @Column(name = "charCode")
    String charCode;

    @Column(name = "nominal")
    String nominal;

    @Column(name = "numCode")
    String shortName;

    @Column(name = "numCode")
    String value;

    @Column(name = "numCode")
    String previousValue;

    public CurrencyData() {
    }

    public CurrencyData(String id, String numCode, String charCode, String nominal, String shortName, String value, String previousValue) {
        this.id = id;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.shortName = shortName;
        this.value = value;
        this.previousValue = previousValue;
    }

    public MainData getName_of_currency() {
        return name_of_currency;
    }

    public void setName_of_currency(MainData name_of_currency) {
        this.name_of_currency = name_of_currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(String previousValue) {
        this.previousValue = previousValue;
    }

    @Override
    public String toString() {
        return "CurrencyData{" +
                "id=" + id +
                ", numCode='" + numCode + '\'' +
                ", charCode='" + charCode + '\'' +
                ", nominal='" + nominal + '\'' +
                ", shortName='" + shortName + '\'' +
                ", value='" + value + '\'' +
                ", previousValue='" + previousValue + '\'' +
                '}';
    }
}

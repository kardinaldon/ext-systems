package entity;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "main_data")
public class MainData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "data")
    String data;

    @Column(name = "previousDate")
    String previousDate;

    @Column(name = "previousURL")
    String previousURL;

    @Column(name = "timestamp")
    String timestamp;

    @OneToMany(mappedBy = "name_of_currency", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CurrencyData> currencyData;

    public MainData() {
    }

    public MainData(String data, String previousDate, String previousURL, String timestamp, List<CurrencyData> currencyData) {
        this.data = data;
        this.previousDate = previousDate;
        this.previousURL = previousURL;
        this.timestamp = timestamp;
        this.currencyData = currencyData;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(String previousDate) {
        this.previousDate = previousDate;
    }

    public String getPreviousURL() {
        return previousURL;
    }

    public void setPreviousURL(String previousURL) {
        this.previousURL = previousURL;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<CurrencyData> getCurrencyData() {
        return currencyData;
    }

    public void setCurrencyData(List<CurrencyData> currencyData) {
        this.currencyData = currencyData;
    }

    @Override
    public String toString() {
        return "MainData{" +
                "data='" + data + '\'' +
                ", previousDate='" + previousDate + '\'' +
                ", previousURL='" + previousURL + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", currencyData=" + currencyData +
                '}';
    }
}

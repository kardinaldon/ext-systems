package com.register_office.view;

import java.io.Serializable;
import java.time.LocalDate;

public class MarriageRequest implements Serializable {

    private String husbandSurname;
    private String husbandGivenName;
    private String husbandPatronymic;
    private LocalDate husbandDateOfBirth;
    private String husbandPassportSeries;
    private String husbandPassportNumber;
    private LocalDate husbandPassportIssueDate;

    private String wifeSurname;
    private String wifeGivenName;
    private String wifePatronymic;
    private LocalDate wifeDateOfBirth;
    private String wifePassportSeries;
    private String wifePassportNumber;
    private LocalDate wifePassportIssueDate;

    private String marriageCertificateNumber;
    private LocalDate marriageCertificateDate;



}

package ru.coursework.bibd.Models.Spravochniki;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SV {
    String tabNum;
    String fio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateOfBirth;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateOfDrLic;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateOfValid;
    String passNum;
    String driverCat;
    String licNum;
    public SV() {
    }

    public SV(String tabNum, String fio, Date dateOfBirth, Date dateOfDrLic, Date dateOfValid, String passNum, String driverCat, String licNum) {
        this.tabNum = tabNum;
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDrLic = dateOfDrLic;
        this.dateOfValid = dateOfValid;
        this.passNum = passNum;
        this.driverCat = driverCat;
        this.licNum = licNum;
    }

    public String getTabNum() {
        return tabNum;
    }

    public void setTabNum(String tabNum) {
        this.tabNum = tabNum;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfDrLic() {
        return dateOfDrLic;
    }

    public void setDateOfDrLic(Date dateOfDrLic) {
        this.dateOfDrLic = dateOfDrLic;
    }

    public Date getDateOfValid() {
        return dateOfValid;
    }

    public void setDateOfValid(Date dateOfValid) {
        this.dateOfValid = dateOfValid;
    }

    public String getPassNum() {
        return passNum;
    }

    public void setPassNum(String passNum) {
        this.passNum = passNum;
    }

    public String getDriverCat() {
        return driverCat;
    }

    public void setDriverCat(String driverCat) {
        this.driverCat = driverCat;
    }

    public String getLicNum() {
        return licNum;
    }

    public void setLicNum(String licNum) {
        this.licNum = licNum;
    }
}

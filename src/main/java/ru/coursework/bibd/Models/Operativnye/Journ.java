package ru.coursework.bibd.Models.Operativnye;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Journ {
    String numReq;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateReq;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date datePlanl;
    String tel;

    public String getNumReq() {
        return numReq;
    }

    public void setNumReq(String numReq) {
        this.numReq = numReq;
    }

    public Date getDateReq() {
        return dateReq;
    }

    public void setDateReq(Date dateReq) {
        this.dateReq = dateReq;
    }

    public Date getDatePlanl() {
        return datePlanl;
    }

    public void setDatePlanl(Date datePlanl) {
        this.datePlanl = datePlanl;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Journ() {
    }

    public Journ(String numReq, Date dateReq, Date datePlanl, String tel) {
        this.numReq = numReq;
        this.dateReq = dateReq;
        this.datePlanl = datePlanl;
        this.tel = tel;
    }
}

package ru.coursework.bibd.Models.Operativnye;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DP {
    String numPlan;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date datePlan;
    String numReq;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateReq;
    String codeIzd;
    String codeRoute;
    String tabNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateFinish;

    public DP(String numPlan, Date datePlan, String numReq, Date dateReq, String codeIzd, String codeRoute, String tabNum, Date dateStart, Date dateFinish) {
        this.numPlan = numPlan;
        this.datePlan = datePlan;
        this.numReq = numReq;
        this.dateReq = dateReq;
        this.codeIzd = codeIzd;
        this.codeRoute = codeRoute;
        this.tabNum = tabNum;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }

    public DP() {
    }

    public String getNumPlan() {
        return numPlan;
    }

    public void setNumPlan(String numPlan) {
        this.numPlan = numPlan;
    }

    public Date getDatePlan() {
        return datePlan;
    }

    public void setDatePlan(Date datePlan) {
        this.datePlan = datePlan;
    }

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

    public String getCodeIzd() {
        return codeIzd;
    }

    public void setCodeIzd(String codeIzd) {
        this.codeIzd = codeIzd;
    }

    public String getCodeRoute() {
        return codeRoute;
    }

    public void setCodeRoute(String codeRoute) {
        this.codeRoute = codeRoute;
    }

    public String getTabNum() {
        return tabNum;
    }

    public void setTabNum(String tabNum) {
        this.tabNum = tabNum;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }
}

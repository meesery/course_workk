package ru.coursework.bibd.Models.Operativnye;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PL {
    String numPl;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date datePl;
    String fioDriv;
    String numAuto;
    String numLic;
    String markAuto;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateFinish;
    String addrRoute;
    String codeRoute;
    String codeIzd;
    double probeg;
    double weight;
    int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PL() {
    }

    public String getNumPl() {
        return numPl;
    }

    public void setNumPl(String numPl) {
        this.numPl = numPl;
    }

    public Date getDatePl() {
        return datePl;
    }

    public void setDatePl(Date datePl) {
        this.datePl = datePl;
    }

    public String getFioDriv() {
        return fioDriv;
    }

    public void setFioDriv(String fioDriv) {
        this.fioDriv = fioDriv;
    }

    public String getNumAuto() {
        return numAuto;
    }

    public void setNumAuto(String numAuto) {
        this.numAuto = numAuto;
    }

    public String getNumLic() {
        return numLic;
    }

    public void setNumLic(String numLic) {
        this.numLic = numLic;
    }

    public String getMarkAuto() {
        return markAuto;
    }

    public void setMarkAuto(String markAuto) {
        this.markAuto = markAuto;
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

    public String getAddrRoute() {
        return addrRoute;
    }

    public void setAddrRoute(String addrRoute) {
        this.addrRoute = addrRoute;
    }

    public String getCodeRoute() {
        return codeRoute;
    }

    public void setCodeRoute(String codeRoute) {
        this.codeRoute = codeRoute;
    }

    public String getCodeIzd() {
        return codeIzd;
    }

    public void setCodeIzd(String codeIzd) {
        this.codeIzd = codeIzd;
    }

    public double getProbeg() {
        return probeg;
    }

    public void setProbeg(double probeg) {
        this.probeg = probeg;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}


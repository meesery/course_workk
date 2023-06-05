package ru.coursework.bibd.Models.Operativnye;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
public class Spec {
    int numSpec;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateSpec;
    String codeIzd;
    String nameIzd;
    String edIzm;
    double weightIzd;
    double volumeIzd;
    int priceIzd;
    int amount;
    String codeRoute;
    int fullPrice = 0;

    public Spec() {
    }

    public Spec(int numSpec, Date dateSpec, String codeIzd, String nameIzd, String edIzm, double weightIzd, double volumeIzd, int priceIzd, int amount, String codeRoute, int fullPrice) {
        this.numSpec = numSpec;
        this.dateSpec = dateSpec;
        this.codeIzd = codeIzd;
        this.nameIzd = nameIzd;
        this.edIzm = edIzm;
        this.weightIzd = weightIzd;
        this.volumeIzd = volumeIzd;
        this.priceIzd = priceIzd;
        this.amount = amount;
        this.codeRoute = codeRoute;
        this.fullPrice = fullPrice;
    }

    public int getNumSpec() {
        return numSpec;
    }

    public void setNumSpec(int numSpec) {
        this.numSpec = numSpec;
    }

    public Date getDateSpec() {
        return dateSpec;
    }

    public void setDateSpec(Date dateSpec) {
        this.dateSpec = dateSpec;
    }

    public String getCodeIzd() {
        return codeIzd;
    }

    public void setCodeIzd(String codeIzd) {
        this.codeIzd = codeIzd;
    }

    public String getNameIzd() {
        return nameIzd;
    }

    public void setNameIzd(String nameIzd) {
        this.nameIzd = nameIzd;
    }

    public String getEdIzm() {
        return edIzm;
    }

    public void setEdIzm(String edIzm) {
        this.edIzm = edIzm;
    }

    public double getWeightIzd() {
        return weightIzd;
    }

    public void setWeightIzd(double weightIzd) {
        this.weightIzd = weightIzd;
    }

    public double getVolumeIzd() {
        return volumeIzd;
    }

    public void setVolumeIzd(double volumeIzd) {
        this.volumeIzd = volumeIzd;
    }

    public int getPriceIzd() {
        return priceIzd;
    }

    public void setPriceIzd(int priceIzd) {
        this.priceIzd = priceIzd;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCodeRoute() {
        return codeRoute;
    }

    public void setCodeRoute(String codeRoute) {
        this.codeRoute = codeRoute;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(int fullPrice) {
        this.fullPrice = fullPrice;
    }
}

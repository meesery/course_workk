package ru.coursework.bibd.Models.Spravochniki;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.lang.NonNull;

public class SSI {

    @NotEmpty(message = "Должно быть заполнено")
    String codeIzd;
    String nameIzd;
    String edIzm;
    int priceIzd;
    double weightIzd;
    double volumeIzd;
    String kindIzd;

    public SSI() {
    }

    public SSI(String codeIzd, String nameIzd, String edIzm, int priceIzd, double weightIzd, double volumeIzd, String kindIzd) {
        this.codeIzd = codeIzd;
        this.nameIzd = nameIzd;
        this.edIzm = edIzm;
        this.priceIzd = priceIzd;
        this.weightIzd = weightIzd;
        this.volumeIzd = volumeIzd;
        this.kindIzd = kindIzd;
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

    public int getPriceIzd() {
        return priceIzd;
    }

    public void setPriceIzd(int priceIzd) {
        this.priceIzd = priceIzd;
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

    public String getKindIzd() {
        return kindIzd;
    }

    public void setKindIzd(String kindIzd) {
        this.kindIzd = kindIzd;
    }
}

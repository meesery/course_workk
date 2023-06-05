package ru.coursework.bibd.Models.Spravochniki;

public class SA {
    String autoNum;
    String autoMark;
    int loadCap;
    int yearProd;
    double firstCost;
    String codeAm;
    double percAm;
    int srokIsp;
    double lastCost;

    public SA(String autoNum, String autoMark, int loadCap, int yearProd, double firstCost, String codeAm, double percAm, int srokIsp, double lastCost) {
        this.autoNum = autoNum;
        this.autoMark = autoMark;
        this.loadCap = loadCap;
        this.yearProd = yearProd;
        this.firstCost = firstCost;
        this.codeAm = codeAm;
        this.percAm = percAm;
        this.srokIsp = srokIsp;
        this.lastCost = lastCost;
    }

    public SA() {
    }

    public String getAutoNum() {
        return autoNum;
    }

    public void setAutoNum(String autoNum) {
        this.autoNum = autoNum;
    }

    public String getAutoMark() {
        return autoMark;
    }

    public void setAutoMark(String autoMark) {
        this.autoMark = autoMark;
    }

    public int getLoadCap() {
        return loadCap;
    }

    public void setLoadCap(int loadCap) {
        this.loadCap = loadCap;
    }

    public int getYearProd() {
        return yearProd;
    }

    public void setYearProd(int yearProd) {
        this.yearProd = yearProd;
    }

    public double getFirstCost() {
        return firstCost;
    }

    public void setFirstCost(double firstCost) {
        this.firstCost = firstCost;
    }

    public String getCodeAm() {
        return codeAm;
    }

    public void setCodeAm(String codeAm) {
        this.codeAm = codeAm;
    }

    public double getPercAm() {
        return percAm;
    }

    public void setPercAm(double percAm) {
        this.percAm = percAm;
    }

    public int getSrokIsp() {
        return srokIsp;
    }

    public void setSrokIsp(int srokIsp) {
        this.srokIsp = srokIsp;
    }

    public double getLastCost() {
        return lastCost;
    }

    public void setLastCost(double lastCost) {
        this.lastCost = lastCost;
    }
}

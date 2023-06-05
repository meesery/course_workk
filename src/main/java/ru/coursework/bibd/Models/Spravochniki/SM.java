package ru.coursework.bibd.Models.Spravochniki;

public class SM {
    String codeRoute;
    String addrRoute;
    double lenRoute;

    public SM(String codeRoute, String addrRoute, double lenRoute) {
        this.codeRoute = codeRoute;
        this.addrRoute = addrRoute;
        this.lenRoute = lenRoute;
    }

    public SM() {
    }

    public String getCodeRoute() {
        return codeRoute;
    }

    public void setCodeRoute(String codeRoute) {
        this.codeRoute = codeRoute;
    }

    public String getAddrRoute() {
        return addrRoute;
    }

    public void setAddrRoute(String addrRoute) {
        this.addrRoute = addrRoute;
    }

    public double getLenRoute() {
        return lenRoute;
    }

    public void setLenRoute(double lenRoute) {
        this.lenRoute = lenRoute;
    }
}

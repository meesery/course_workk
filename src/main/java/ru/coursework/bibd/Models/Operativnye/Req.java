package ru.coursework.bibd.Models.Operativnye;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Req {
    String numReq;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date date_req;
    int num_spec;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date date_spec;
    String code_route;
    String dest;
    int price_trans;
    String tel;
    String  code_izd;

    public Req(String numReq, Date date_req, int num_spec, Date date_spec, String code_route, String dest, int price_trans, String tel, String code_izd) {
        this.numReq = numReq;
        this.date_req = date_req;
        this.num_spec = num_spec;
        this.date_spec = date_spec;
        this.code_route = code_route;
        this.dest = dest;
        this.price_trans = price_trans;
        this.tel = tel;
        this.code_izd = code_izd;
    }

    public Req() {
    }

    public String getNumReq() {
        return numReq;
    }

    public void setNumReq(String numReq) {
        this.numReq = numReq;
    }

    public Date getDate_req() {
        return date_req;
    }

    public void setDate_req(Date date_req) {
        this.date_req = date_req;
    }

    public int getNum_spec() {
        return num_spec;
    }

    public void setNum_spec(int num_spec) {
        this.num_spec = num_spec;
    }

    public Date getDate_spec() {
        return date_spec;
    }

    public void setDate_spec(Date date_spec) {
        this.date_spec = date_spec;
    }

    public String getCode_route() {
        return code_route;
    }

    public void setCode_route(String code_route) {
        this.code_route = code_route;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public int getPrice_trans() {
        return price_trans;
    }

    public void setPrice_trans(int price_trans) {
        this.price_trans = price_trans;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCode_izd() {
        return code_izd;
    }

    public void setCode_izd(String code_izd) {
        this.code_izd = code_izd;
    }
}

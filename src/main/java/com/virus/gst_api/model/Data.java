package com.virus.gst_api.model;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private String stjCd;
    private String stj;
    private String dty;
    private String lgnm;
    private List<Adadr> adadr = new ArrayList<Adadr>();
    private String cxdt;
    private List<String> nba = new ArrayList<String>();
    private String gstin;
    private String lstupdt;
    private String ctb;
    private String rgdt;
    private Pradr pradr;
    private String sts;
    private String ctjCd;
    private String tradeNam;
    private String ctj;

    public String getStjCd() {
        return stjCd;
    }

    public void setStjCd(String stjCd) {
        this.stjCd = stjCd;
    }

    public String getStj() {
        return stj;
    }

    public void setStj(String stj) {
        this.stj = stj;
    }

    public String getDty() {
        return dty;
    }

    public void setDty(String dty) {
        this.dty = dty;
    }

    public String getLgnm() {
        return lgnm;
    }

    public void setLgnm(String lgnm) {
        this.lgnm = lgnm;
    }

    public List<Adadr> getAdadr() {
        return adadr;
    }

    public void setAdadr(List<Adadr> adadr) {
        this.adadr = adadr;
    }

    public String getCxdt() {
        return cxdt;
    }

    public void setCxdt(String cxdt) {
        this.cxdt = cxdt;
    }

    public List<String> getNba() {
        return nba;
    }

    public void setNba(List<String> nba) {
        this.nba = nba;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getLstupdt() {
        return lstupdt;
    }

    public void setLstupdt(String lstupdt) {
        this.lstupdt = lstupdt;
    }

    public String getCtb() {
        return ctb;
    }

    public void setCtb(String ctb) {
        this.ctb = ctb;
    }

    public String getRgdt() {
        return rgdt;
    }

    public void setRgdt(String rgdt) {
        this.rgdt = rgdt;
    }

    public Pradr getPradr() {
        return pradr;
    }

    public void setPradr(Pradr pradr) {
        this.pradr = pradr;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getCtjCd() {
        return ctjCd;
    }

    public void setCtjCd(String ctjCd) {
        this.ctjCd = ctjCd;
    }

    public String getTradeNam() {
        return tradeNam;
    }

    public void setTradeNam(String tradeNam) {
        this.tradeNam = tradeNam;
    }

    public String getCtj() {
        return ctj;
    }

    public void setCtj(String ctj) {
        this.ctj = ctj;
    }
}

package com.guige.springbootdemo.entity;

public class ConfParser {
    private Long id;

    private String prodCd;

    private String parserName;

    private String multipleDateFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdCd() {
        return prodCd;
    }

    public void setProdCd(String prodCd) {
        this.prodCd = prodCd;
    }

    public String getParserName() {
        return parserName;
    }

    public void setParserName(String parserName) {
        this.parserName = parserName;
    }

    public String getMultipleDateFlag() {
        return multipleDateFlag;
    }

    public void setMultipleDateFlag(String multipleDateFlag) {
        this.multipleDateFlag = multipleDateFlag;
    }
}
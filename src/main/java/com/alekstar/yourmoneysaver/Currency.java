package com.alekstar.yourmoneysaver;

public class Currency implements Comparable<Currency> {
    private long id;
    private String name;
    private String isoCode;
    private String symbol;
    private String comments;

    public Currency(String name, String isoCode, String sign) {
        setName(name);
        setIsoCode(isoCode);
        setSymbol(sign);
    }

    public long getId() {
        return id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getComments() {
        return comments;
    }

    private void setId(long id) {
        this.id = id;
    }

    private void setIsoCode(String iSOCode) {
        isoCode = iSOCode;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int compareTo(Currency currency) {
        return this.getIsoCode().compareTo(currency.getIsoCode());
    }
}

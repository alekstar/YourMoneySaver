package com.alekstar.yourmoneysaver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Currencies")
public class Currency implements Comparable<Currency> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "iso_code", nullable = false)
    private String isoCode;

    @Column(nullable = false)
    private String symbol;

    @Column
    private String comments;

    public Currency(String name, String isoCode, String symbol, String comments) {
        setName(name);
        setIsoCode(isoCode);
        setSymbol(symbol);
        setComments(comments);
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

    @SuppressWarnings("unused")
    private void setId(long id) {
        this.id = id;
    }

    public void setIsoCode(String iSOCode) {
        isoCode = iSOCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
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

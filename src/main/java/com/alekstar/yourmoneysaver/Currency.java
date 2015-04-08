package com.alekstar.yourmoneysaver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

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

    @SuppressWarnings("unused")
    private Currency() {

    }

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

    public void setIsoCode(String isoCode) {
        if (isoCode == null) {
            throw new ArgumentIsNullException("isoCode");
        }
        if (!isoCode.matches(defineRegularExpressionForIsoCode())) {
            throw new IllegalArgumentException("Iso code is not valid.");
        }
        this.isoCode = isoCode;
    }

    private String defineRegularExpressionForIsoCode() {
        return "^[A-Z][A-Z][A-Z]$";
    }

    public void setName(String name) {
        if (name == null) {
            throw new ArgumentIsNullException("name");
        }
        this.name = name;
    }

    public void setSymbol(String symbol) {
        if (symbol == null) {
            throw new ArgumentIsNullException("symbol");
        }
        if (symbol.length() != defineSymbolStringLength()) {
            throw new IllegalArgumentException(
                    "Currency's symbol should be exactly one character.");
        }
        this.symbol = symbol;
    }

    private int defineSymbolStringLength() {
        return 1;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int compareTo(Currency currency) {
        return this.getIsoCode().compareTo(currency.getIsoCode());
    }
}

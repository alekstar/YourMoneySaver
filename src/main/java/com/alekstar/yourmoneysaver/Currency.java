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
    private static final int NAME_MAX_STRING_LENGTH = 50;
    private static final int ISO_CODE_STRING_LENGTH = 3;
    private static final int SYMBOL_STRING_LENGTH = 1;
    private static final int COMMENTS_MAX_STRING_LENGTH = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(nullable = false, length = NAME_MAX_STRING_LENGTH)
    private String name;

    @Column(name = "iso_code", nullable = false, length = ISO_CODE_STRING_LENGTH)
    private String isoCode;

    @Column(nullable = false, length = SYMBOL_STRING_LENGTH)
    private String symbol;

    @Column(length = COMMENTS_MAX_STRING_LENGTH)
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
        if (isoCode.length() != ISO_CODE_STRING_LENGTH) {
            throw new IllegalArgumentException(
                    "ISO code should be consisted of 3 letters.");
        }
        if (!isoCode.matches(defineRegularExpressionForIsoCode())) {
            throw new IllegalArgumentException("ISO code is not valid.");
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
        if (name.length() > NAME_MAX_STRING_LENGTH) {
            StringBuilder exceptionMessageBuilder = new StringBuilder();
            exceptionMessageBuilder
                    .append("Length of name's string can not be more than ");
            exceptionMessageBuilder.append(NAME_MAX_STRING_LENGTH);
            exceptionMessageBuilder.append(" symbols.");
            throw new IllegalArgumentException(
                    exceptionMessageBuilder.toString());
        }
        this.name = name;
    }

    public void setSymbol(String symbol) {
        if (symbol == null) {
            throw new ArgumentIsNullException("symbol");
        }
        if (symbol.length() != SYMBOL_STRING_LENGTH) {
            throw new IllegalArgumentException(
                    "Currency's symbol should be exactly one character.");
        }
        this.symbol = symbol;
    }

    public void setComments(String comments) {
        if (comments != null && comments.length() > COMMENTS_MAX_STRING_LENGTH) {
            StringBuilder exceptionMessageBuilder = new StringBuilder();
            exceptionMessageBuilder
                    .append("Length of comments' string can not be more than ");
            exceptionMessageBuilder.append(COMMENTS_MAX_STRING_LENGTH);
            exceptionMessageBuilder.append(" symbols.");
            throw new IllegalArgumentException(
                    exceptionMessageBuilder.toString());
        }
        this.comments = comments;
    }

    @Override
    public int compareTo(Currency currency) {
        return this.getIsoCode().compareTo(currency.getIsoCode());
    }
}

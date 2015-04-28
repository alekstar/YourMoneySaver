package com.alekstar.yourmoneysaver;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

public class Currency implements Comparable<Currency> {
    public static final int NAME_MAX_STRING_LENGTH = 50;
    public static final int ISO_CODE_STRING_LENGTH = 3;
    public static final int SYMBOL_STRING_LENGTH = 1;
    public static final int COMMENTS_MAX_STRING_LENGTH = 100;

    private String name;
    private String isoCode;
    private String symbol;
    private String comments;

    public Currency(String name, String isoCode, String symbol, String comments) {
        setName(name);
        setIsoCode(isoCode);
        setSymbol(symbol);
        setComments(comments);
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

    private String defineRegularExpressionForIsoCode() {
        return "^[A-Z][A-Z][A-Z]$";
    }

    @Override
    public int compareTo(Currency currency) {
        return this.getIsoCode().compareTo(currency.getIsoCode());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result =
                prime * result + ((comments == null) ? 0 : comments.hashCode());
        result = prime * result + ((isoCode == null) ? 0 : isoCode.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Currency other = (Currency) obj;
        if (comments == null) {
            if (other.comments != null)
                return false;
        } else if (!comments.equals(other.comments))
            return false;
        if (isoCode == null) {
            if (other.isoCode != null)
                return false;
        } else if (!isoCode.equals(other.isoCode))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (symbol == null) {
            if (other.symbol != null)
                return false;
        } else if (!symbol.equals(other.symbol))
            return false;
        return true;
    }
}

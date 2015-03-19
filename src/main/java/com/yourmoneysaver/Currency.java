package com.yourmoneysaver;

public class Currency implements Comparable<Currency> {
    private String name;
    private String isoCode;
    private String sign;

    public Currency(String name, String isoCode, String sign) {
        setName(name);
        setIsoCode(isoCode);
        setSign(sign);
    }

    public String getIsoCode() {
        return isoCode;
    }

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }

    private void setIsoCode(String iSOCode) {
        isoCode = iSOCode;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public int compareTo(Currency currency) {
        return this.getIsoCode().compareTo(currency.getIsoCode());
    }
}

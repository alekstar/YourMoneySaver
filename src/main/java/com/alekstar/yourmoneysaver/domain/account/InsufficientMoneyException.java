package com.alekstar.yourmoneysaver.domain.account;
import com.alekstar.yourmoneysaver.domain.money.Money;

public class InsufficientMoneyException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final Money rest;

    public InsufficientMoneyException(Money rest) {
        super();
        this.rest = rest;
    }

    public Money getRest() {
        return rest;
    }
}

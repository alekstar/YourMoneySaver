package com.alekstar.yourmoneysaver.domain.account;
import com.alekstar.yourmoneysaver.domain.money.Money;

public class InsufficientMoneyException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final Money rest;
    private final Money requestedSum;

    public InsufficientMoneyException(Money rest, Money requestedSum) {
        super();
        this.rest = rest;
        this.requestedSum = requestedSum;
    }

    public Money getRest() {
        return rest;
    }

    public Money getRequestedSum() {
        return requestedSum;
    }
}

package com.alekstar.yourmoneysaver.domain.account;

public class InsufficientMoneyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InsufficientMoneyException(String message) {
        super(message);
    }
}

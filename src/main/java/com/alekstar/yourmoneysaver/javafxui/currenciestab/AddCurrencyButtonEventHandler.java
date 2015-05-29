package com.alekstar.yourmoneysaver.javafxui.currenciestab;

public class AddCurrencyButtonEventHandler extends AbstractButtonEventHandler {
    private AddCurrency addCurrency;

    protected AddCurrencyButtonEventHandler(AddCurrency addCurrency) {
        this.addCurrency = addCurrency;
    }

    public static AddCurrencyButtonEventHandler create(AddCurrency addCurrency) {
        return new AddCurrencyButtonEventHandler(addCurrency);
    }

    private void addCurrency() {
        this.addCurrency.addCurrency();
    }

    @Override
    protected void executeAction() {
        addCurrency();
    }
}

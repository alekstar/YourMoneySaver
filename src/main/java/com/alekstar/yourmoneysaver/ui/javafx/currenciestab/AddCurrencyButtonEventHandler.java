package com.alekstar.yourmoneysaver.ui.javafx.currenciestab;

public class AddCurrencyButtonEventHandler extends AbstractButtonEventHandler {
    private AbleToAddCurrency ableToAddCurrency;

    protected AddCurrencyButtonEventHandler(AbleToAddCurrency ableToAddCurrency) {
        this.ableToAddCurrency = ableToAddCurrency;
    }

    public static AddCurrencyButtonEventHandler create(AbleToAddCurrency ableToAddCurrency) {
        return new AddCurrencyButtonEventHandler(ableToAddCurrency);
    }

    private void addCurrency() {
        this.ableToAddCurrency.addCurrency();
    }

    @Override
    protected void executeAction() {
        addCurrency();
    }
}

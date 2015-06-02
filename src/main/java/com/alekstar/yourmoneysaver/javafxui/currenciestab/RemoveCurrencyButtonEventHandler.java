package com.alekstar.yourmoneysaver.javafxui.currenciestab;

public class RemoveCurrencyButtonEventHandler extends
        AbstractButtonEventHandler {
    private RemoveCurrency parentWindow;

    protected RemoveCurrencyButtonEventHandler(RemoveCurrency parentWindow) {
        setParentWindow(parentWindow);
    }

    public static RemoveCurrencyButtonEventHandler create(
            RemoveCurrency parentWindow) {
        return new RemoveCurrencyButtonEventHandler(parentWindow);
    }

    private RemoveCurrency getParentWindow() {
        return parentWindow;
    }

    private void setParentWindow(RemoveCurrency parentWindow) {
        this.parentWindow = parentWindow;
    }

    @Override
    protected void executeAction() {
        getParentWindow().removeCurrency();
    }

}

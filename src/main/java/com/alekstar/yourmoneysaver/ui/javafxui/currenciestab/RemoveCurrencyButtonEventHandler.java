package com.alekstar.yourmoneysaver.ui.javafxui.currenciestab;

public class RemoveCurrencyButtonEventHandler extends
        AbstractButtonEventHandler {
    private AbleToRemoveCurrency parentWindow;

    protected RemoveCurrencyButtonEventHandler(AbleToRemoveCurrency parentWindow) {
        setParentWindow(parentWindow);
    }

    public static RemoveCurrencyButtonEventHandler create(
            AbleToRemoveCurrency parentWindow) {
        return new RemoveCurrencyButtonEventHandler(parentWindow);
    }

    private AbleToRemoveCurrency getParentWindow() {
        return parentWindow;
    }

    private void setParentWindow(AbleToRemoveCurrency parentWindow) {
        this.parentWindow = parentWindow;
    }

    @Override
    protected void executeAction() {
        getParentWindow().removeCurrency();
    }

}

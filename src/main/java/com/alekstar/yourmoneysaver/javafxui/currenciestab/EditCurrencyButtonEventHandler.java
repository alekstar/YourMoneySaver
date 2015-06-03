package com.alekstar.yourmoneysaver.javafxui.currenciestab;

public class EditCurrencyButtonEventHandler extends AbstractButtonEventHandler {
    private AbleToEditCurrency parentWindow;

    protected EditCurrencyButtonEventHandler(AbleToEditCurrency parentWindow) {
        setParentWindow(parentWindow);
    }

    public static EditCurrencyButtonEventHandler create(
            AbleToEditCurrency parentWindow) {
        return new EditCurrencyButtonEventHandler(parentWindow);
    }

    private AbleToEditCurrency getParentWindow() {
        return parentWindow;
    }

    private void setParentWindow(AbleToEditCurrency parentWindow) {
        this.parentWindow = parentWindow;
    }

    @Override
    protected void executeAction() {
        getParentWindow().editCurrency();
    }
}

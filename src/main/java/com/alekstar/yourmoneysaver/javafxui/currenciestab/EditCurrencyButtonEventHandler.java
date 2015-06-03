package com.alekstar.yourmoneysaver.javafxui.currenciestab;

public class EditCurrencyButtonEventHandler extends AbstractButtonEventHandler {
    private EditCurrency parentWindow;

    protected EditCurrencyButtonEventHandler(EditCurrency parentWindow) {
        setParentWindow(parentWindow);
    }

    public static EditCurrencyButtonEventHandler create(
            EditCurrency parentWindow) {
        return new EditCurrencyButtonEventHandler(parentWindow);
    }

    private EditCurrency getParentWindow() {
        return parentWindow;
    }

    private void setParentWindow(EditCurrency parentWindow) {
        this.parentWindow = parentWindow;
    }

    @Override
    protected void executeAction() {
        getParentWindow().editCurrency();
    }
}

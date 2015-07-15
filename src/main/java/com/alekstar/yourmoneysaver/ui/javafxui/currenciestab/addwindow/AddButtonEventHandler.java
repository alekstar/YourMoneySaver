package com.alekstar.yourmoneysaver.ui.javafxui.currenciestab.addwindow;

import com.alekstar.yourmoneysaver.ui.javafxui.currenciestab.AbstractButtonEventHandler;

public class AddButtonEventHandler extends AbstractButtonEventHandler {
    private AddCurrencyWindow parentWindow;

    protected AddButtonEventHandler(AddCurrencyWindow parentWindow) {
        setParentWindow(parentWindow);
    }

    public static AddButtonEventHandler create(AddCurrencyWindow parentWindow) {
        return new AddButtonEventHandler(parentWindow);
    }

    private AddCurrencyWindow getParentWindow() {
        return parentWindow;
    }

    private void setParentWindow(AddCurrencyWindow parentWindow) {
        this.parentWindow = parentWindow;
    }

    @Override
    protected void executeAction() {
        getParentWindow().createNewCurrency();
    }
}

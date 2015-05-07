package com.alekstar.yourmoneysaver.javafxui.currenciestab;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.javafxui.currenciestab.addwindow.AddCurrencyWindow;
import javafx.stage.Window;

public class AddCurrencyButtonEventHandler extends AbstractButtonEventHandler {
    private Window parentWindow;
    private CurrenciesData currenciesData;

    protected AddCurrencyButtonEventHandler(Window parentWindow,
            CurrenciesData currenciesData) {
        setParentWindow(parentWindow);
        setCurrenciesData(currenciesData);
    }

    public static AddCurrencyButtonEventHandler create(Window parentWindow,
            CurrenciesData currenciesData) {
        return new AddCurrencyButtonEventHandler(parentWindow, currenciesData);
    }

    private void setParentWindow(Window parentWindow) {
        if (parentWindow == null) {
            throw new ArgumentIsNullException("parentWindow");
        }
        this.parentWindow = parentWindow;
    }

    private Window getParentWindow() {
        return parentWindow;
    }

    private CurrenciesData getCurrenciesData() {
        return currenciesData;
    }

    private void setCurrenciesData(CurrenciesData currenciesData) {
        this.currenciesData = currenciesData;
    }

    @Override
    protected void executeAction() {
        AddCurrencyWindow window =
                AddCurrencyWindow
                        .create(getParentWindow(), getCurrenciesData());
        window.showAndWait();
    }
}

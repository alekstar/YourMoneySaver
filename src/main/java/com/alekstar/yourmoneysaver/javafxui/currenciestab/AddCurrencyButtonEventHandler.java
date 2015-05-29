package com.alekstar.yourmoneysaver.javafxui.currenciestab;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.javafxui.currenciestab.addwindow.AddCurrencyWindow;
import javafx.stage.Window;

public class AddCurrencyButtonEventHandler extends AbstractButtonEventHandler {
    private Window parentWindow;
    private CurrenciesData currenciesData;
    private Refreshable currenciesTable;
    private AddCurrency addCurrency;

    protected AddCurrencyButtonEventHandler(Window parentWindow,
            CurrenciesData currenciesData, Refreshable currenciesTable,
            AddCurrency addCurrency) {
        setParentWindow(parentWindow);
        setCurrenciesData(currenciesData);
        setCurrenciesTable(currenciesTable);
        this.addCurrency = addCurrency;
    }

    public static AddCurrencyButtonEventHandler create(Window parentWindow,
            CurrenciesData currenciesData, Refreshable currenciesTable,
            AddCurrency addCurrency) {
        return new AddCurrencyButtonEventHandler(parentWindow, currenciesData,
                currenciesTable, addCurrency);
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

    private Refreshable getCurrenciesTable() {
        return currenciesTable;
    }

    private void setCurrenciesTable(Refreshable currenciesTable) {
        this.currenciesTable = currenciesTable;
    }

    private void addCurrency() {
        this.addCurrency.addCurrency();
    }

    @Override
    protected void executeAction() {
        addCurrency();
    }
}

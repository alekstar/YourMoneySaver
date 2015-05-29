package com.alekstar.yourmoneysaver.javafxui.currenciestab;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.javafxui.currenciestab.addwindow.AddCurrencyWindow;
import javafx.stage.Window;

public class AddCurrencyButtonEventHandler extends AbstractButtonEventHandler {
    private Window parentWindow;
    private CurrenciesData currenciesData;
    private Refreshable currenciesTable;

    protected AddCurrencyButtonEventHandler(Window parentWindow,
            CurrenciesData currenciesData, Refreshable currenciesTable) {
        setParentWindow(parentWindow);
        setCurrenciesData(currenciesData);
        setCurrenciesTable(currenciesTable);
    }

    public static AddCurrencyButtonEventHandler create(Window parentWindow,
            CurrenciesData currenciesData, Refreshable currenciesTable) {
        return new AddCurrencyButtonEventHandler(parentWindow, currenciesData,
                currenciesTable);
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

    @Override
    protected void executeAction() {
        AddCurrencyWindow window =
                AddCurrencyWindow
                        .create(getParentWindow(), getCurrenciesData());
        window.showAndWait();
        refreshCurrenciesTable();
    }

    private void refreshCurrenciesTable() {
        getCurrenciesTable().refresh();
    }
}

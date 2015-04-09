package com.alekstar.yourmoneysaver.javafxui.currenciestab;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.javafxui.currenciestab.addwindow.AddCurrencyWindow;

import javafx.event.EventHandler;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;

public class AddCurrencyButtonEventHandler extends AbstractButtonEventHandler {
    private CurrenciesTable currenciesTable;
    private Window parentWindow;

    protected AddCurrencyButtonEventHandler(CurrenciesTable currenciesTable,
            Window parentWindow) {
        setCurrenciesTable(currenciesTable);
        setParentWindow(parentWindow);
    }

    public static AddCurrencyButtonEventHandler create(
            CurrenciesTable currenciesTable, Window parentWindow) {
        return new AddCurrencyButtonEventHandler(currenciesTable, parentWindow);
    }

    private void setCurrenciesTable(CurrenciesTable currenciesTable) {
        if (currenciesTable == null) {
            throw new ArgumentIsNullException("currenciesTable");
        }
        this.currenciesTable = currenciesTable;
    }

    private CurrenciesTable getCurrenciesTable() {
        return this.currenciesTable;
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

    @Override
    protected void executeAction() {
        AddCurrencyWindow window = AddCurrencyWindow.create(getParentWindow());
        window.showAndWait();
    }
}

package com.alekstar.yourmoneysaver.javafxui;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

import javafx.event.EventHandler;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;

public class AddCurrencyButtonEventHandler implements EventHandler<InputEvent> {
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

    private boolean isAcceptibleEvent(InputEvent event) {
        if (isAcceptibleEventType(event)) {
            return false;
        }
        if (event instanceof MouseEvent) {
            MouseEvent mouseEvent = (MouseEvent) event;
            if (!isAcceptibleMouseEvent(mouseEvent)) {
                return false;
            }
        }
        if (event instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent) event;
            if (!isAcceptibleKeyEvent(keyEvent)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAcceptibleEventType(InputEvent event) {
        if(!(event instanceof MouseEvent) && !(event instanceof KeyEvent)) {
            return false;
        }
        return true;
    }

    private boolean isAcceptibleMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != MouseButton.PRIMARY) {
            return false;
        }
        if (mouseEvent.getEventType() != MouseEvent.MOUSE_CLICKED) {
            return false;
        }
        return true;
    }

    private boolean isAcceptibleKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getCode() != KeyCode.ENTER) {
            return false;
        }
        return true;
    }

    @Override
    public void handle(InputEvent event) {
        if (!isAcceptibleEvent(event)) {
            return;
        }
        AddCurrencyWindow window = AddCurrencyWindow.create(getParentWindow());
        window.showAndWait();
    }
}

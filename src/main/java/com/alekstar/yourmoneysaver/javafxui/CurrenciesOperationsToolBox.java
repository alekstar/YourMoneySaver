package com.alekstar.yourmoneysaver.javafxui;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;
import com.sun.glass.events.KeyEvent;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Window;

public class CurrenciesOperationsToolBox {
    private HBox box = new HBox();
    private CurrenciesTable currenciesTable;
    private Window parentWindow;

    public static CurrenciesOperationsToolBox create(
            CurrenciesTable currenciesTable, Window parentWindow) {
        return new CurrenciesOperationsToolBox(currenciesTable, parentWindow);
    }

    private CurrenciesOperationsToolBox(CurrenciesTable currenciesTable,
            Window parentWindow) {
        setParentWindow(parentWindow);
        setCurrenciesTable(currenciesTable);
        initializeBox();
        addButtons();
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

    public HBox getBox() {
        return box;
    }

    private Window getParentWindow() {
        return parentWindow;
    }

    private void setParentWindow(Window parentWindow) {
        if (parentWindow == null) {
            throw new ArgumentIsNullException("parentWindow");
        }
        this.parentWindow = parentWindow;
    }

    private void initializeBox() {
        getBox().setPadding(Standarts.defineToolBoxInsets());
        getBox().setSpacing(Standarts.defineToolBoxSpacing());
    }

    private void addNode(Node node) {
        if (box == null) {
            throw new ArgumentIsNullException("node");
        }
        getBox().getChildren().add(node);
    }

    private void addAddButton() {
        Button button = new Button("Add");
        AddCurrencyButtonEventHandler pressedHandler =
                AddCurrencyButtonEventHandler.create(getCurrenciesTable(),
                        getParentWindow());
        button.setOnKeyPressed(pressedHandler);
        button.setOnMouseClicked(pressedHandler);
        addNode(button);
    }

    private void addEditButton() {
        Button button = new Button("Edit");
        addNode(button);
    }

    private void addRemoveButton() {
        Button button = new Button("Remove");
        addNode(button);
    }

    private void addButtons() {
        addAddButton();
        addEditButton();
        addRemoveButton();
    }

}

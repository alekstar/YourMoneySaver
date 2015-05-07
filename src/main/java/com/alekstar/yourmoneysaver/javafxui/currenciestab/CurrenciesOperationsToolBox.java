package com.alekstar.yourmoneysaver.javafxui.currenciestab;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.javafxui.Standarts;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Window;

public class CurrenciesOperationsToolBox {
    private HBox box = new HBox();
    private Window parentWindow;
    private CurrenciesData currenciesData;

    public static CurrenciesOperationsToolBox create(Window parentWindow,
            CurrenciesData currenciesData) {
        return new CurrenciesOperationsToolBox(parentWindow, currenciesData);
    }

    private CurrenciesOperationsToolBox(Window parentWindow,
            CurrenciesData currenciesData) {
        setCurrenciesData(currenciesData);
        setParentWindow(parentWindow);
        initializeBox();
        addButtons();
    }

    public HBox getBox() {
        return box;
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
                AddCurrencyButtonEventHandler.create(getParentWindow(),
                        getCurrenciesData());
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

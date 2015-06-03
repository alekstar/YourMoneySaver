package com.alekstar.yourmoneysaver.javafxui.currenciestab;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.javafxui.Standarts;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CurrenciesOperationsToolBox {
    private HBox box = new HBox();
    private AbleToAddCurrency ableToAddCurrency;
    private RemoveCurrency removeCurrency;
    private EditCurrency editCurrency;

    public static CurrenciesOperationsToolBox create(AbleToAddCurrency ableToAddCurrency,
            RemoveCurrency removeCurrency, EditCurrency editCurrency) {
        return new CurrenciesOperationsToolBox(ableToAddCurrency, removeCurrency,
                editCurrency);
    }

    private CurrenciesOperationsToolBox(AbleToAddCurrency ableToAddCurrency,
            RemoveCurrency removeCurrency, EditCurrency editCurrency) {
        this.ableToAddCurrency = ableToAddCurrency;
        this.removeCurrency = removeCurrency;
        this.editCurrency = editCurrency;
        initializeBox();
        addButtons();
    }

    private AbleToAddCurrency getAbleToAddCurrency() {
        return this.ableToAddCurrency;
    }

    private RemoveCurrency getRemoveCurrency() {
        return this.removeCurrency;
    }

    private EditCurrency getEditCurrency() {
        return this.editCurrency;
    }

    public HBox getBox() {
        return box;
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
                AddCurrencyButtonEventHandler.create(getAbleToAddCurrency());
        button.setOnKeyPressed(pressedHandler);
        button.setOnMouseClicked(pressedHandler);
        addNode(button);
    }

    private void addEditButton() {
        Button button = new Button("Edit");
        EditCurrencyButtonEventHandler pressedHandler =
                EditCurrencyButtonEventHandler.create(getEditCurrency());
        button.setOnKeyPressed(pressedHandler);
        button.setOnMouseClicked(pressedHandler);
        addNode(button);
    }

    private void addRemoveButton() {
        Button button = new Button("Remove");
        RemoveCurrencyButtonEventHandler pressedHandler =
                RemoveCurrencyButtonEventHandler.create(getRemoveCurrency());
        button.setOnKeyPressed(pressedHandler);
        button.setOnMouseClicked(pressedHandler);
        addNode(button);
    }

    private void addButtons() {
        addAddButton();
        addEditButton();
        addRemoveButton();
    }

}

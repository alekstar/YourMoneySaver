package com.alekstar.yourmoneysaver.ui.javafxui.currenciestab;

import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.ui.javafxui.Standarts;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CurrenciesOperationsToolBox {
    private HBox box = new HBox();
    private AbleToAddCurrency ableToAddCurrency;
    private AbleToRemoveCurrency ableToRemoveCurrency;
    private AbleToEditCurrency ableToEditCurrency;

    public static CurrenciesOperationsToolBox create(AbleToAddCurrency ableToAddCurrency,
            AbleToRemoveCurrency ableToRemoveCurrency, AbleToEditCurrency ableToEditCurrency) {
        return new CurrenciesOperationsToolBox(ableToAddCurrency, ableToRemoveCurrency,
                ableToEditCurrency);
    }

    private CurrenciesOperationsToolBox(AbleToAddCurrency ableToAddCurrency,
            AbleToRemoveCurrency ableToRemoveCurrency, AbleToEditCurrency ableToEditCurrency) {
        this.ableToAddCurrency = ableToAddCurrency;
        this.ableToRemoveCurrency = ableToRemoveCurrency;
        this.ableToEditCurrency = ableToEditCurrency;
        initializeBox();
        addButtons();
    }

    private AbleToAddCurrency getAbleToAddCurrency() {
        return this.ableToAddCurrency;
    }

    private AbleToRemoveCurrency getAbleToRemoveCurrency() {
        return this.ableToRemoveCurrency;
    }

    private AbleToEditCurrency getEditCurrency() {
        return this.ableToEditCurrency;
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
                RemoveCurrencyButtonEventHandler.create(getAbleToRemoveCurrency());
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

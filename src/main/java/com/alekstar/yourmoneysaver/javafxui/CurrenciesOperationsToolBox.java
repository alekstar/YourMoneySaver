package com.alekstar.yourmoneysaver.javafxui;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CurrenciesOperationsToolBox {
    private HBox box = new HBox();

    public static CurrenciesOperationsToolBox create() {
        return new CurrenciesOperationsToolBox();
    }

    private CurrenciesOperationsToolBox() {
        initializeBox();
        addAddButton();
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
        addNode(button);
    }

}

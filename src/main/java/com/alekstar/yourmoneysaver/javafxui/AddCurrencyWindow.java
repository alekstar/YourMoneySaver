package com.alekstar.yourmoneysaver.javafxui;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import com.alekstar.yourmoneysaver.Currency;
import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

public class AddCurrencyWindow {
    Currency newCurrency;
    Stage thisWindow;
    Window parentWindow;

    protected AddCurrencyWindow(Window parentWindow) {
        setParentWindow(parentWindow);

        initializeThisWindow();
    }

    public static AddCurrencyWindow create(Window parentWindow) {
        return new AddCurrencyWindow(parentWindow);
    }

    private void initializeThisWindow() {
        Stage window = new Stage();
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane, 500, 500);
        window.setScene(scene);
        window.initOwner(getParentWindow());
        window.initModality(Modality.WINDOW_MODAL);
        window.setResizable(false);
        window.setTitle("Add new currency");
        VBox vBox = new VBox();
        stackPane.getChildren().add(vBox);
        setThisWindow(window);
    }

    public void showAndWait() {
        getThisWindow().showAndWait();
    }

    private Currency getNewCurrency() {
        return newCurrency;
    }

    private void setNewCurrency(Currency newCurrency) {
        this.newCurrency = newCurrency;
    }

    private Stage getThisWindow() {
        return thisWindow;
    }

    private void setThisWindow(Stage thisWindow) {
        if (thisWindow == null) {
            throw new ArgumentIsNullException("thisWindow");
        }
        this.thisWindow = thisWindow;
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

}

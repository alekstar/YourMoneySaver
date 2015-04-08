package com.alekstar.yourmoneysaver.javafxui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import com.alekstar.yourmoneysaver.Currency;
import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

public class AddCurrencyWindow {
    private Currency newCurrency;
    private Stage thisWindow;
    private Window parentWindow;

    protected AddCurrencyWindow(Window parentWindow) {
        setParentWindow(parentWindow);
        initializeThisWindow();
    }

    public static AddCurrencyWindow create(Window parentWindow) {
        return new AddCurrencyWindow(parentWindow);
    }

    private void addControlsToPane(Pane pane) {
        VBox vBox = new VBox();
        vBox.getChildren().add(new Label("Name: "));
        vBox.getChildren().add(new TextField());
        vBox.getChildren().add(new Label("ISO code: "));
        vBox.getChildren().add(new TextField());
        vBox.getChildren().add(new Label("Symbol: "));
        vBox.getChildren().add(new TextField());
        vBox.getChildren().add(new Label("Comments: "));
        vBox.getChildren().add(new TextField());
        vBox.setPadding(Standarts.defineMainPanelInsets());

        HBox hBox = new HBox();
        hBox.getChildren().add(new Button("Add"));
        hBox.setPadding(Standarts.defineToolBoxInsets());
        vBox.getChildren().add(hBox);

        pane.getChildren().add(vBox);
    }

    private void initializeThisWindow() {
        Stage window = new Stage();
        StackPane stackPane = new StackPane();
        addControlsToPane(stackPane);
        Scene scene = new Scene(stackPane, 500, 200);
        window.setScene(scene);
        window.initOwner(getParentWindow());
        window.initModality(Modality.WINDOW_MODAL);
        window.setResizable(false);
        window.setTitle("Add new currency");
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

package com.alekstar.yourmoneysaver.javafxui;

import com.alekstar.yourmoneysaver.domain.Account;
import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddAccountWindow {
    private Stage parentWindow;
    private Stage thisWindow;
    private StackPane rootPane;
    private Account newAccount;

    private AddAccountWindow() {

    }

    public static AddAccountWindow create(Stage parentWindow) {
        AddAccountWindow addAccountWindow = new AddAccountWindow();
        addAccountWindow.setParentWindow(parentWindow);
        addAccountWindow.initializeThisWindow();
        addAccountWindow.addControlsToThisWindow();
        return addAccountWindow;
    }

    public Account getNewAccount() {
        return newAccount;
    }

    private void setNewAccount(Account newAccount) {
        if (newAccount == null) {
            throw new ArgumentIsNullException("newAccount");
        }
        this.newAccount = newAccount;
    }

    public StackPane getRootPane() {
        return rootPane;
    }

    private void setRootPane(StackPane rootPane) {
        if (rootPane == null) {
            throw new ArgumentIsNullException("rootPane");
        }
        this.rootPane = rootPane;
    }

    private void initializeThisWindow() {
        setRootPane(new StackPane());
        setThisWindow(new Stage());
        Scene mainWindow = new Scene(getRootPane(), getWidth(), getHeight());
        getThisWindow().setScene(mainWindow);
        getThisWindow().initOwner(getParentWindow());
        getThisWindow().initModality(Modality.WINDOW_MODAL);
        getThisWindow().setResizable(false);
    }

    private Label getNewLabel(String labelText) {
        return new Label(labelText);
    }

    private Label getNameFieldLabel() {
        return getNewLabel(getNameFieldLabelText());
    }

    private String getNameFieldLabelText() {
        return "Name";
    }

    private TextField getNewTextField() {
        return new TextField();
    }

    private void addControlsToThisWindow() {
        VBox mainPane = new VBox();
        mainPane.getChildren().add(getNameFieldLabel());
        TextField nameTextField = getNewTextField();

        mainPane.getChildren().add(nameTextField);
        mainPane.setPadding(getMainPanePadding());
        getRootPane().getChildren().add(mainPane);
    }

    private int getHeight() {
        return 500;
    }

    private int getWidth() {
        return 500;
    }

    public Stage getThisWindow() {
        return thisWindow;
    }

    private void setThisWindow(Stage thisWindow) {
        if (thisWindow == null) {
            throw new ArgumentIsNullException("thisWindow");
        }
        this.thisWindow = thisWindow;
    }

    public Stage getParentWindow() {
        return parentWindow;
    }

    private void setParentWindow(Stage parentWindow) {
        if (parentWindow == null) {
            throw new ArgumentIsNullException("parentWindow");
        }
        this.parentWindow = parentWindow;
    }

    public void showAndWait() {
        getThisWindow().showAndWait();
    }

    private Insets getMainPanePadding() {
        return new Insets(10, 10, 10, 10);
    }
}

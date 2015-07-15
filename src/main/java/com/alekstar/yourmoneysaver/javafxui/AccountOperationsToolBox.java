package com.alekstar.yourmoneysaver.javafxui;

import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AccountOperationsToolBox {
    private class AddAccountButtonAction implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            AddAccountWindow addAccountWindow =
                    AddAccountWindow.create(parentWindow);
            addAccountWindow.showAndWait();
        }
    }

    private class EditAccountButtonAction implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            AccountsTableDataStructure selectedAccount =
                    getTableView().getSelectionModel().getSelectedItem();
            if (selectedAccount != null) {
                System.out.println("Editing account "
                        + selectedAccount.getName());
            }
        }
    }

    private HBox box;
    private TableView<AccountsTableDataStructure> tableView;
    private Stage parentWindow;

    public AccountOperationsToolBox(
            TableView<AccountsTableDataStructure> accountsTableView,
            Stage parentWindow) {
        setParentWindow(parentWindow);
        setBox(new HBox());
        setTableView(accountsTableView);
        defineParameters();
        addButtonsToBox();
    }

    private void addButtonsToBox() {
        getBox().getChildren().add(getAddAccountButton());
        getBox().getChildren().add(getEditAccountButton());
        getBox().getChildren().add(getRemoveAccountButton());
    }

    private void defineParameters() {
        getBox().setPadding(getInsideOffsets());
        getBox().setSpacing(getNiceSpacing());
    }

    private Button getAddAccountButton() {
        Button button = new Button(getAddAccountButtonText());
        button.setOnMouseClicked(new AddAccountButtonAction());
        return button;
    }

    private String getAddAccountButtonText() {
        return "Add";
    }

    public HBox getBox() {
        return box;
    }

    private Button getEditAccountButton() {
        Button button = new Button(getEditAccountButtonText());
        button.setOnMouseClicked(new EditAccountButtonAction());
        return button;
    }

    private String getEditAccountButtonText() {
        return "Edit";
    }

    public HBox getHBox() {
        return this.box;
    }

    private Insets getInsideOffsets() {
        return Standarts.defineToolBoxInsets();
    }

    private double getNiceSpacing() {
        return Standarts.defineToolBoxSpacing();
    }

    public Stage getParentWindow() {
        return parentWindow;
    }

    private Button getRemoveAccountButton() {
        return new Button(getRemoveAccountButtonText());
    }

    private String getRemoveAccountButtonText() {
        return "Remove";
    }

    public TableView<AccountsTableDataStructure> getTableView() {
        return tableView;
    }

    public void setBox(HBox box) {
        if (box == null) {
            throw new ArgumentIsNullException("box");
        }
        this.box = box;
    }

    public void setParentWindow(Stage parentWindow) {
        if (parentWindow == null) {
            throw new ArgumentIsNullException("parentWindow");
        }
        this.parentWindow = parentWindow;
    }

    public void setTableView(TableView<AccountsTableDataStructure> tableView) {
        if (tableView == null) {
            throw new ArgumentIsNullException("tableView");
        }
        this.tableView = tableView;
    }
}

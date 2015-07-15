package com.alekstar.yourmoneysaver.ui.javafxui;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;

public class AccountsTable {
    private TableView<AccountsTableDataStructure> tableView;

    private AccountsTable() {

    }

    public static AccountsTable create(
            List<AccountsTableDataStructure> accountsData) {
        AccountsTable accountsTable = new AccountsTable();
        accountsTable.setTableView(new TableView<AccountsTableDataStructure>());
        accountsTable.prepareTable(FXCollections
                .observableArrayList(accountsData));
        return accountsTable;
    }

    public TableView<AccountsTableDataStructure> getTableView() {
        return tableView;
    }

    private void setTableView(TableView<AccountsTableDataStructure> tableView) {
        if (tableView == null) {
            throw new ArgumentIsNullException("tableView");
        }
        this.tableView = tableView;
    }

    private String getAccountCommentsFieldName() {
        return "comments";
    }

    private String getAccountNameFieldName() {
        return "name";
    }

    private String getAccountRestFieldName() {
        return "rest";
    }

    private String getAccountCurrencyCodeFieldName() {
        return "currencyCode";
    }

    private String getAccountTypeFieldName() {
        return "type";
    }

    private String getColumnNameForAccountComments() {
        return "Comments";
    }

    private String getColumnNameForAccountName() {
        return "Name";
    }

    private String getColumnNameForAccountRest() {
        return "Rest";
    }

    private String getColumnNameForAccountCurrencyCode() {
        return "Currency code";
    }

    private String getColumnNameForAccountType() {
        return "Type";
    }

    private void prepareTable(
            ObservableList<AccountsTableDataStructure> accountsData) {
        TableColumn<AccountsTableDataStructure, String> name =
                new TableColumn<AccountsTableDataStructure, String>(
                        getColumnNameForAccountName());
        name.setCellValueFactory(new PropertyValueFactory<AccountsTableDataStructure, String>(
                getAccountNameFieldName()));
        TableColumn<AccountsTableDataStructure, String> type =
                new TableColumn<AccountsTableDataStructure, String>(
                        getColumnNameForAccountType());
        type.setCellValueFactory(new PropertyValueFactory<AccountsTableDataStructure, String>(
                getAccountTypeFieldName()));
        TableColumn<AccountsTableDataStructure, String> rest =
                new TableColumn<AccountsTableDataStructure, String>(
                        getColumnNameForAccountRest());
        rest.setCellValueFactory(new PropertyValueFactory<AccountsTableDataStructure, String>(
                getAccountRestFieldName()));
        TableColumn<AccountsTableDataStructure, String> currencyCode =
                new TableColumn<AccountsTableDataStructure, String>(
                        getColumnNameForAccountCurrencyCode());
        currencyCode
                .setCellValueFactory(new PropertyValueFactory<AccountsTableDataStructure, String>(
                        getAccountCurrencyCodeFieldName()));
        TableColumn<AccountsTableDataStructure, String> comments =
                new TableColumn<AccountsTableDataStructure, String>(
                        getColumnNameForAccountComments());
        comments.setCellValueFactory(new PropertyValueFactory<AccountsTableDataStructure, String>(
                getAccountCommentsFieldName()));

        getTableView().getColumns().add(name);
        getTableView().getColumns().add(type);
        getTableView().getColumns().add(rest);
        getTableView().getColumns().add(currencyCode);
        getTableView().getColumns().add(comments);
        getTableView().setItems(accountsData);
    }
}

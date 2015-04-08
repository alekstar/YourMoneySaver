package com.alekstar.yourmoneysaver.javafxui.currenciestab;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.alekstar.yourmoneysaver.Currency;
import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

public class CurrenciesTable {
    private TableView<Currency> tableView;

    private CurrenciesTable(List<Currency> currenciesData) {
        setTableView(new TableView<Currency>());
        prepareTable(currenciesData);
    }

    public static CurrenciesTable create(List<Currency> currenciesData) {
        CurrenciesTable currenciesTable = new CurrenciesTable(currenciesData);
        return currenciesTable;
    }

    private String defineColumnNameForCurrencyName() {
        return "Name";
    }

    private String defineCurrencyNameFieldName() {
        return "name";
    }

    private String defineColumnNameForCurrencyIsoCode() {
        return "ISO Code";
    }

    private String defineCurrencyIsoCodeFieldName() {
        return "isoCode";
    }

    private String defineColumnNameForCurrencySymbol() {
        return "Symbol";
    }

    private String defineCurrencySymbolFieldName() {
        return "symbol";
    }

    private String defineColumnNameForCurrencyComments() {
        return "Comments";
    }

    private String defineCurrencyCommentsFieldName() {
        return "comments";
    }

    private void prepareTable(List<Currency> currenciesData) {
        getTableView().getColumns().add(defineNameColumn());
        getTableView().getColumns().add(defineIsoCodeColumn());
        getTableView().getColumns().add(defineSymbolColumn());
        getTableView().getColumns().add(defineCommentsColumn());
        getTableView().setItems(
                FXCollections.observableArrayList(currenciesData));

    }

    private TableColumn<Currency, String> defineCommentsColumn() {
        TableColumn<Currency, String> comments =
                new TableColumn<Currency, String>(
                        defineColumnNameForCurrencyComments());
        comments.setCellValueFactory(new PropertyValueFactory<Currency, String>(
                defineCurrencyCommentsFieldName()));
        return comments;
    }

    private TableColumn<Currency, String> defineNameColumn() {
        TableColumn<Currency, String> name =
                new TableColumn<Currency, String>(
                        defineColumnNameForCurrencyName());
        name.setCellValueFactory(new PropertyValueFactory<Currency, String>(
                defineCurrencyNameFieldName()));
        return name;
    }

    private TableColumn<Currency, String> defineIsoCodeColumn() {
        TableColumn<Currency, String> isoCode =
                new TableColumn<Currency, String>(
                        defineColumnNameForCurrencyIsoCode());
        isoCode.setCellValueFactory(new PropertyValueFactory<Currency, String>(
                defineCurrencyIsoCodeFieldName()));
        return isoCode;
    }

    private TableColumn<Currency, String> defineSymbolColumn() {
        TableColumn<Currency, String> symbol =
                new TableColumn<Currency, String>(
                        defineColumnNameForCurrencySymbol());
        symbol.setCellValueFactory(new PropertyValueFactory<Currency, String>(
                defineCurrencySymbolFieldName()));
        return symbol;
    }

    public TableView<Currency> getTableView() {
        return tableView;
    }

    protected void setTableView(TableView<Currency> tableView) {
        if (tableView == null) {
            throw new ArgumentIsNullException("tableView");
        }
        this.tableView = tableView;
    }

    public Currency getCurrencyFromCurrentPosition() {
        return getTableView().getFocusModel().getFocusedItem();
    }
}

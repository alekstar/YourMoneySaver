package com.yourmoneysaver.javafxui;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.yourmoneysaver.Currency;
import com.yourmoneysaver.exceptions.ArgumentIsNullException;

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

    private String defineColumnNameForCurrencySign() {
        return "Sign";
    }

    private String defineCurrencySignFieldName() {
        return "sign";
    }

    private void prepareTable(List<Currency> currenciesData) {
        TableColumn<Currency, String> name =
                new TableColumn<Currency, String>(
                        defineColumnNameForCurrencyName());
        name.setCellValueFactory(new PropertyValueFactory<Currency, String>(
                defineCurrencyNameFieldName()));
        TableColumn<Currency, String> isoCode =
                new TableColumn<Currency, String>(
                        defineColumnNameForCurrencyIsoCode());
        isoCode.setCellValueFactory(new PropertyValueFactory<Currency, String>(
                defineCurrencyIsoCodeFieldName()));
        TableColumn<Currency, String> sign =
                new TableColumn<Currency, String>(
                        defineColumnNameForCurrencySign());
        sign.setCellValueFactory(new PropertyValueFactory<Currency, String>(
                defineCurrencySignFieldName()));
        getTableView().getColumns().add(name);
        getTableView().getColumns().add(isoCode);
        getTableView().getColumns().add(sign);
        getTableView().setItems(
                FXCollections.observableArrayList(currenciesData));

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
}

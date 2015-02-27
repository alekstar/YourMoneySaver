package com.yourmoneysaver.javafxui;

import java.util.List;

import javafx.scene.control.TableView;

import com.yourmoneysaver.Currency;
import com.yourmoneysaver.exceptions.ArgumentIsNullException;

public class CurrenciesTable {
    private TableView<Currency> tableView;

    private CurrenciesTable(List<Currency> currenciesData) {
        setTableView(new TableView<Currency>());
        prepareTable(currenciesData);
    }

    public CurrenciesTable create(List<Currency> currenciesData) {
        CurrenciesTable currenciesTable = new CurrenciesTable(currenciesData);
        return currenciesTable;
    }

    private void prepareTable(List<Currency> currenciesData) {
    }

    protected TableView<Currency> getTableView() {
        return tableView;
    }

    protected void setTableView(TableView<Currency> tableView) {
        if (tableView == null) {
            throw new ArgumentIsNullException("tableView");
        }
        this.tableView = tableView;
    }
}

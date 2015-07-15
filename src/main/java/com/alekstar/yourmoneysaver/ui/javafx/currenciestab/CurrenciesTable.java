package com.alekstar.yourmoneysaver.ui.javafx.currenciestab;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.alekstar.yourmoneysaver.database.CurrencyEntity;
import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;

public class CurrenciesTable implements Refreshable {
    private TableView<CurrencyEntity> tableView;
    private CurrenciesData currenciesData;

    private CurrenciesTable(CurrenciesData currenciesData) {
        setTableView(new TableView<CurrencyEntity>());
        setCurrenciesData(currenciesData);
        prepareTable();
    }

    public static CurrenciesTable create(CurrenciesData currenciesData) {
        CurrenciesTable currenciesTable = new CurrenciesTable(currenciesData);
        return currenciesTable;
    }

    public TableView<CurrencyEntity> getTableView() {
        return tableView;
    }

    protected void setTableView(TableView<CurrencyEntity> tableView) {
        if (tableView == null) {
            throw new ArgumentIsNullException("tableView");
        }
        this.tableView = tableView;
    }

    public CurrenciesData getCurrenciesData() {
        return currenciesData;
    }

    private void setCurrenciesData(CurrenciesData currenciesData) {
        this.currenciesData = currenciesData;
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

    private void prepareTable() {
        getTableView().getColumns().add(defineNameColumn());
        getTableView().getColumns().add(defineIsoCodeColumn());
        getTableView().getColumns().add(defineSymbolColumn());
        getTableView().getColumns().add(defineCommentsColumn());
        setData();
    }

    private TableColumn<CurrencyEntity, String> defineCommentsColumn() {
        TableColumn<CurrencyEntity, String> comments =
                new TableColumn<CurrencyEntity, String>(
                        defineColumnNameForCurrencyComments());
        comments.setCellValueFactory(new PropertyValueFactory<CurrencyEntity, String>(
                defineCurrencyCommentsFieldName()));
        return comments;
    }

    private TableColumn<CurrencyEntity, String> defineNameColumn() {
        TableColumn<CurrencyEntity, String> name =
                new TableColumn<CurrencyEntity, String>(
                        defineColumnNameForCurrencyName());
        name.setCellValueFactory(new PropertyValueFactory<CurrencyEntity, String>(
                defineCurrencyNameFieldName()));
        return name;
    }

    private TableColumn<CurrencyEntity, String> defineIsoCodeColumn() {
        TableColumn<CurrencyEntity, String> isoCode =
                new TableColumn<CurrencyEntity, String>(
                        defineColumnNameForCurrencyIsoCode());
        isoCode.setCellValueFactory(new PropertyValueFactory<CurrencyEntity, String>(
                defineCurrencyIsoCodeFieldName()));
        return isoCode;
    }

    private TableColumn<CurrencyEntity, String> defineSymbolColumn() {
        TableColumn<CurrencyEntity, String> symbol =
                new TableColumn<CurrencyEntity, String>(
                        defineColumnNameForCurrencySymbol());
        symbol.setCellValueFactory(new PropertyValueFactory<CurrencyEntity, String>(
                defineCurrencySymbolFieldName()));
        return symbol;
    }

    public CurrencyEntity getCurrencyFromCurrentPosition() {
        return getTableView().getFocusModel().getFocusedItem();
    }

    public void setData() {
        getTableView().setItems(
                FXCollections
                        .observableArrayList(getCurrenciesData().getList()));
    }

    @Override
    public void refresh() {
        setData();
    }
}

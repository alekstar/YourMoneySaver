package com.alekstar.yourmoneysaver.javafxui.currenciestab;

import java.util.Optional;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.alekstar.yourmoneysaver.CurrenciesDataAccessObject;
import com.alekstar.yourmoneysaver.database.CurrencyEntity;
import com.alekstar.yourmoneysaver.javafxui.AbstractTab;
import com.alekstar.yourmoneysaver.javafxui.Standarts;
import com.alekstar.yourmoneysaver.javafxui.currenciestab.addwindow.AddCurrencyWindow;

public class CurrenciesTab extends AbstractTab implements AddCurrency,
        RemoveCurrency {
    private CurrenciesDataAccessObject currenciesDataAccessObject;
    private CurrenciesTable table;
    private Pane mainPanel;
    private CurrenciesData currenciesData;

    private CurrenciesTab(Stage parentWindow,
            CurrenciesDataAccessObject currenciesDataAccessObject) {
        super(parentWindow);
        setCurrenciesDataAccessObject(currenciesDataAccessObject);
        initializeCurrenciesData();
    }

    public static CurrenciesTab create(Stage parentWindow,
            CurrenciesDataAccessObject currenciesDataAccessObject) {
        CurrenciesTab tab =
                new CurrenciesTab(parentWindow, currenciesDataAccessObject);
        tab.constructTab();
        return tab;
    }

    private CurrenciesTable getTable() {
        return this.table;
    }

    public Pane getMainPanel() {
        return this.mainPanel;
    }

    public CurrenciesDataAccessObject getCurrenciesDataAccessObject() {
        return this.currenciesDataAccessObject;
    }

    private void setCurrenciesDataAccessObject(
            CurrenciesDataAccessObject currenciesDataAccessObject) {
        this.currenciesDataAccessObject = currenciesDataAccessObject;
    }

    private CurrenciesData getCurrenciesData() {
        return currenciesData;
    }

    private void setCurrenciesData(CurrenciesData currenciesData) {
        this.currenciesData = currenciesData;
    }

    @Override
    protected String defineName() {
        return "Currencies";
    }

    @Override
    protected void constructTab() {
        initializeTable();
        initializeMainPanel();
        getTab().setContent(getMainPanel());
    }

    private void initializeTable() {
        this.table = CurrenciesTable.create(getCurrenciesData());
    }

    private void initializeCurrenciesData() {
        setCurrenciesData(defineCurrenciesData());
    }

    private CurrenciesDataUsingDataAccessObject defineCurrenciesData() {
        return CurrenciesDataUsingDataAccessObject
                .create(getCurrenciesDataAccessObject());
    }

    private void initializeMainPanel() {
        this.mainPanel = new VBox();
        getMainPanel().getChildren().add(getTable().getTableView());
        getMainPanel().getChildren().add(defineToolBox());
        getMainPanel().setPadding(Standarts.defineMainPanelInsets());
    }

    private Node defineToolBox() {
        CurrenciesOperationsToolBox toolBox =
                CurrenciesOperationsToolBox.create(this);
        return toolBox.getBox();
    }

    @Override
    public void addCurrency() {
        AddCurrencyWindow window =
                AddCurrencyWindow
                        .create(getParentWindow(), getCurrenciesData());
        window.showAndWait();
        refreshCurrenciesTable();
    }

    private void refreshCurrenciesTable() {
        getTable().refresh();
    }

    private void removeCurrency(CurrencyEntity currencyEntity) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation for removing currency");
        alert.setHeaderText("Do you really want to remove selected currency?");

        ButtonType buttonTypeYes = new ButtonType("Yes", ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("No", ButtonData.NO);

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYes) {
            getCurrenciesDataAccessObject().remove(currencyEntity);
        }
    }

    @Override
    public void removeCurrency() {
        CurrencyEntity selectedItem =
                getTable().getTableView().getSelectionModel().getSelectedItem();

        removeCurrency(selectedItem);
    }
}

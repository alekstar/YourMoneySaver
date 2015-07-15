package com.alekstar.yourmoneysaver.javafxui.currenciestab;

import java.util.Optional;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.alekstar.yourmoneysaver.database.CurrencyEntity;
import com.alekstar.yourmoneysaver.domain.CurrenciesDataAccessObject;
import com.alekstar.yourmoneysaver.javafxui.AbstractTab;
import com.alekstar.yourmoneysaver.javafxui.Standarts;
import com.alekstar.yourmoneysaver.javafxui.currenciestab.addwindow.AddCurrencyWindow;

public class CurrenciesTab extends AbstractTab implements AbleToAddCurrency,
        AbleToRemoveCurrency, AbleToEditCurrency {
    private CurrenciesTable table;
    private Pane mainPanel;
    private CurrenciesData currenciesData;

    private CurrenciesTab(Stage parentWindow,
            CurrenciesDataAccessObject currenciesDataAccessObject) {
        super(parentWindow);
        initializeCurrenciesData(currenciesDataAccessObject);
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

    private void initializeCurrenciesData(
            CurrenciesDataAccessObject currenciesDataAccessObject) {
        setCurrenciesData(defineCurrenciesData(currenciesDataAccessObject));
    }

    private CurrenciesDataUsingDataAccessObject defineCurrenciesData(
            CurrenciesDataAccessObject currenciesDataAccessObject) {
        return CurrenciesDataUsingDataAccessObject
                .create(currenciesDataAccessObject);
    }

    private void initializeMainPanel() {
        this.mainPanel = new VBox();
        getMainPanel().getChildren().add(getTable().getTableView());
        getMainPanel().getChildren().add(defineToolBox());
        getMainPanel().setPadding(Standarts.defineMainPanelInsets());
    }

    private Node defineToolBox() {
        CurrenciesOperationsToolBox toolBox =
                CurrenciesOperationsToolBox.create(this, this, this);
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

    private void setDefaultButtonFlag(Alert alert, ButtonType buttonType,
            boolean isDefaultButtonFlag) {
        Button button = (Button) alert.getDialogPane().lookupButton(buttonType);
        button.setDefaultButton(isDefaultButtonFlag);
    }

    private void removeCurrency(CurrencyEntity currencyEntity) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation for removing currency");
        alert.setHeaderText("Confirmation for removing currency");
        alert.setContentText("Do you really want to remove currency \""
                + currencyEntity.getName() + "\"?");

        ButtonType buttonTypeYes = new ButtonType("Yes", ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("No", ButtonData.NO);

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        switchDefaultButton(alert, buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYes) {
            removeCurrencyFromCurrencyData(currencyEntity);
        }
    }

    private void switchDefaultButton(Alert alert, ButtonType fromButton,
            ButtonType toButton) {
        setDefaultButtonFlag(alert, fromButton, false);
        setDefaultButtonFlag(alert, toButton, true);
    }

    private void removeCurrencyFromCurrencyData(CurrencyEntity currencyEntity) {
        getCurrenciesData().remove(currencyEntity);
    }

    private CurrencyEntity defineSelectedItem() {
        return getTable().getTableView().getSelectionModel().getSelectedItem();

    }

    @Override
    public void removeCurrency() {
        CurrencyEntity selectedItem = defineSelectedItem();
        if (selectedItem != null) {
            removeCurrency(selectedItem);
            refreshCurrenciesTable();
        }
    }

    @Override
    public void editCurrency() {
        CurrencyEntity selectedItem = defineSelectedItem();
        if (selectedItem != null) {
            editCurrency(selectedItem);
            refreshCurrenciesTable();
        }
    }

    private void editCurrency(CurrencyEntity currencyEntity) {
        currencyEntity.setComments("EDITED");
        getCurrenciesData().save(currencyEntity);
    }
}

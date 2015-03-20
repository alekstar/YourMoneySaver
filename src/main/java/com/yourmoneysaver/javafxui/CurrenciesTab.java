package com.yourmoneysaver.javafxui;

import java.util.ArrayList;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.alekstar.yourmoneysaver.CurrenciesContainer;
import com.alekstar.yourmoneysaver.Currency;
import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

public class CurrenciesTab extends AbstractTab {
    CurrenciesContainer currenciesContainer;

    private CurrenciesTab(Stage parentWindow) {
        super(parentWindow);
    }

    public static CurrenciesTab create(Stage parentWindow,
            CurrenciesContainer currencies) {
        CurrenciesTab tab = new CurrenciesTab(parentWindow);
        tab.setCurrenciesContainer(currencies);
        tab.constructTab();
        return tab;
    }

    protected void setCurrenciesContainer(
            CurrenciesContainer currenciesContainer) {
        if (currenciesContainer == null) {
            throw new ArgumentIsNullException("currenciesContainer");
        }
        this.currenciesContainer = currenciesContainer;
    }

    public CurrenciesContainer getCurrenciesContainer() {
        return currenciesContainer;
    }

    @Override
    protected String defineName() {
        return "Currencies";
    }

    @Override
    protected void constructTab() {
        VBox mainPanel = new VBox();
        CurrenciesTable currenciesTable =
                CurrenciesTable.create(new ArrayList<Currency>(
                        getCurrenciesContainer().getCurrencies()));
        mainPanel.getChildren().add(currenciesTable.getTableView());
        getTab().setContent(mainPanel);
    }
}

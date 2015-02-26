package com.yourmoneysaver.javafxui;

import javafx.stage.Stage;

public class CurrenciesTab extends AbstractTab {

    private CurrenciesTab(Stage parentWindow) {
        super(parentWindow);
    }

    public static CurrenciesTab create(Stage parentWindow) {
        return new CurrenciesTab(parentWindow);
    }

    @Override
    protected String defineName() {
        return "Currencies";
    }

    @Override
    protected void constructTab() {

    }
}

package com.alekstar.yourmoneysaver.ui.javafx;

import com.alekstar.yourmoneysaver.database.currency.CurrenciesAtJpa;
import com.alekstar.yourmoneysaver.database.currency.CurrenciesDataAccessObject;
import com.alekstar.yourmoneysaver.ui.javafx.currenciestab.CurrenciesTab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class YourMoneySaverUsingJavaFX extends Application {

    private final static Logger logger = Logger.getLogger(YourMoneySaverUsingJavaFX.class);

    @Override
    public void start(Stage primaryStage) {
        logger.info("Starting application");

        TabPane mainPanel = getMainPanel(primaryStage);

        StackPane root = new StackPane();
        root.getChildren().add(mainPanel);

        Scene mainWindow = new Scene(root, 500, 500);

        primaryStage.setTitle("YourMoneySaver");
        primaryStage.setScene(mainWindow);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private TabPane getMainPanel(Stage parentWindow) {
        TabPane mainPanel = new TabPane();

        AccountsTab accountsTab = AccountsTab.create(parentWindow);
        CurrenciesDataAccessObject currenciesDataAccessObject =
                CurrenciesAtJpa.create(EntityManagerFactorySingleton
                        .getEntityManager());
        CurrenciesTab currenciesTab =
                CurrenciesTab.create(parentWindow, currenciesDataAccessObject);

        Tab accounts = accountsTab.getTab();
        Tab history = getHistoryTab();
        Tab currencies = currenciesTab.getTab();

        mainPanel.getTabs().add(accounts);
        mainPanel.getTabs().add(history);
        mainPanel.getTabs().add(currencies);
        return mainPanel;
    }

    private Tab getHistoryTab() {
        Tab history = new Tab();
        history.setText("History");
        history.setClosable(false);
        return history;
    }

    public static void main(String[] args) {
        try {
            launch(args);
        } finally {
            logger.info("Attempt to close EntityManagerFactory.");
            EntityManagerFactorySingleton.close();
        }
    }
}

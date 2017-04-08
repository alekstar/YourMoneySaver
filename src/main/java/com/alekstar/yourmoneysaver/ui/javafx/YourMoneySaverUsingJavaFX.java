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
        initialize(primaryStage);
        primaryStage.show();
    }

    private void initialize(Stage primaryStage) {
        primaryStage.setTitle("YourMoneySaver");
        primaryStage.setScene(defineMainWindow(primaryStage));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }

    private Scene defineMainWindow(Stage primaryStage) {
        final StackPane rootPane = defineRootPane(primaryStage);
        return new Scene(rootPane, 500, 500);
    }

    private StackPane defineRootPane(Stage primaryStage) {
        final TabPane mainPanel = defineMainPanel(primaryStage);

        final StackPane root = new StackPane();
        root.getChildren().add(mainPanel);
        return root;
    }

    private TabPane defineMainPanel(Stage parentWindow) {
        final TabPane mainPanel = new TabPane();
        mainPanel.getTabs().add(defineAccountsTab(parentWindow));
        mainPanel.getTabs().add(defineHistoryTab());
        mainPanel.getTabs().add(defineCurrenciesTab(parentWindow));
        return mainPanel;
    }

    private Tab defineCurrenciesTab(Stage parentWindow) {
        final CurrenciesDataAccessObject currenciesDataAccessObject =
                CurrenciesAtJpa.create(EntityManagerFactorySingleton.getEntityManager());
        final CurrenciesTab currenciesTab = CurrenciesTab.create(parentWindow, currenciesDataAccessObject);
        return currenciesTab.getTab();
    }

    private Tab defineAccountsTab(Stage parentWindow) {
        final AccountsTab accountsTab = AccountsTab.create(parentWindow);
        return accountsTab.getTab();
    }

    private Tab defineHistoryTab() {
        final Tab historyTab = new Tab();
        historyTab.setText("History");
        historyTab.setClosable(false);
        return historyTab;
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

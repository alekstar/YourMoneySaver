package com.alekstar.yourmoneysaver.javafxui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.alekstar.yourmoneysaver.CurrenciesContainer;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

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
        CurrenciesContainer currenciesContainer = CurrenciesContainer.create();
        CurrenciesTab currenciesTab =
                CurrenciesTab.create(parentWindow, currenciesContainer);

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
        launch(args);
    }
}

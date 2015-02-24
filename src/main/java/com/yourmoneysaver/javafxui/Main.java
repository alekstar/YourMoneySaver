package com.yourmoneysaver.javafxui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
		
		Tab accounts = accountsTab.getTab();
		Tab history = getHistoryTab(); 
		
		mainPanel.getTabs().add(accounts);
		mainPanel.getTabs().add(history);
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
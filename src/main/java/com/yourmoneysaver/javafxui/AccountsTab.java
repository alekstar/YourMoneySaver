package com.yourmoneysaver.javafxui;
import javafx.scene.control.Tab;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AccountsTab {
	
	public Tab getTab() {
	    Tab accounts = new Tab();
		accounts.setText(getAccountsTabText());
		accounts.setClosable(false);
		VBox vBox = new VBox();
		AccountsTable accountsTable = new AccountsTable();
		vBox.getChildren().add(accountsTable.getTable());
		HBox accountOperationsToolBox = getAccountOperationsToolBox();
		vBox.getChildren().add(accountOperationsToolBox);
		vBox.setPadding(getVBoxInsideOffsets());
		accounts.setContent(vBox);
	    return accounts;
    }

	private Insets getVBoxInsideOffsets() {
	    return new Insets(10, 10, 10, 10);
    }

	private String getAccountsTabText() {
	    return "Accounts";
    }

	private HBox getAccountOperationsToolBox() {
	    AccountOperationsToolBox accountOperationsToolBox = 
	    		new AccountOperationsToolBox();
	    return accountOperationsToolBox.getHBox();
    }
}

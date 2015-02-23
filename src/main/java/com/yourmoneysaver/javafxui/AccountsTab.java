package com.yourmoneysaver.javafxui;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
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
		TableView<AccountsTableDataStructure> accountsTableView = 
				accountsTable.getTable();
		vBox.getChildren().add(accountsTableView);
		HBox accountOperationsToolBox = getAccountOperationsToolBox(accountsTableView);
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

	private HBox getAccountOperationsToolBox(
			TableView<AccountsTableDataStructure> accountsTableView) {
	    AccountOperationsToolBox accountOperationsToolBox = 
	    		new AccountOperationsToolBox(accountsTableView);
	    return accountOperationsToolBox.getHBox();
    }
}

package com.yourmoneysaver.javafxui;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountsTab {
	Stage parentWindow;
	
	public static AccountsTab getTab(Stage parentWindow) {
		AccountsTab accountsTab = new AccountsTab();
		accountsTab.setParentWindow(parentWindow);
		return accountsTab;
	}

	private HBox getAccountOperationsToolBox(
			TableView<AccountsTableDataStructure> accountsTableView) {
	    AccountOperationsToolBox accountOperationsToolBox = 
	    		new AccountOperationsToolBox(accountsTableView, getParentWindow());
	    return accountOperationsToolBox.getHBox();
    }

	private String getAccountsTabText() {
	    return "Accounts";
    }

	public Stage getParentWindow() {
		return parentWindow;
	}

	public Tab getTab() {
	    Tab accounts = new Tab();
		accounts.setText(getAccountsTabText());
		accounts.setClosable(false);
		VBox vBox = new VBox();
		AccountsTable accountsTable = new AccountsTable();
		TableView<AccountsTableDataStructure> accountsTableView = 
				accountsTable.getTable();
		vBox.getChildren().add(accountsTableView);
		HBox accountOperationsToolBox = 
				getAccountOperationsToolBox(accountsTableView);
		vBox.getChildren().add(accountOperationsToolBox);
		vBox.setPadding(getVBoxInsideOffsets());
		accounts.setContent(vBox);
	    return accounts;
    }

	private Insets getVBoxInsideOffsets() {
	    return new Insets(10, 10, 10, 10);
    }

	public void setParentWindow(Stage parentWindow) {
		if(parentWindow == null) {
			throw new IllegalArgumentException(
					"Argument parentWidnow is null.");
		}
		this.parentWindow = parentWindow;
	}
}

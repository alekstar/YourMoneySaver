package com.yourmoneysaver.javafxui;
import java.util.ArrayList;

import com.yourmoneysaver.Account;
import com.yourmoneysaver.AccountType;
import com.yourmoneysaver.Currency;
import com.yourmoneysaver.Money;

import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountsTab {
	Stage parentWindow;
	
	private AccountsTab() {
		
	}
	
	public static AccountsTab create(Stage parentWindow) {
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

	private ArrayList<AccountsTableDataStructure> getTestingAccountsData() {
		ArrayList<AccountsTableDataStructure> accountsData = 
				new ArrayList<AccountsTableDataStructure>();
		Currency uah = new Currency("Ukrainian hryvnia", "UAH", "₴");
		AccountType plasticCard = new AccountType("Plastic card");
		
		Account account = new Account("SwedenBank Card", plasticCard,
		        new Money(uah, 150, 45), "Issued in 19.02.2015");
		accountsData.add(AccountsTableDataStructure.create(account));
		
		Account anotherAccount = new Account("PolishBank Card", 
				plasticCard, new Money(uah, 1457, 87), "Issued in 23.02.2015");
		accountsData.add(AccountsTableDataStructure.create(anotherAccount));
		
		return accountsData;
	}

	public Tab getTab() {
	    Tab accounts = new Tab();
		accounts.setText(getAccountsTabText());
		accounts.setClosable(false);
		VBox vBox = new VBox();
		AccountsTable accountsTable = 
				AccountsTable.create(getTestingAccountsData());
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

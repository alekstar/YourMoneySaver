package com.yourmoneysaver.javafxui;

import com.yourmoneysaver.Account;
import com.yourmoneysaver.AccountType;
import com.yourmoneysaver.Currency;
import com.yourmoneysaver.Money;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AccountsTable {
	private final ObservableList<AccountsTableDataStructure> accounts = FXCollections
	        .observableArrayList();

	private void fillAccountsWithTestData() {
		Currency uah = new Currency("Ukrainian hryvnia", "UAH", "₴");
		AccountType plasticCard = new AccountType("Plastic card");
		Account account = new Account("SwedenBank Card", plasticCard,
		        new Money(uah, 150, 45), "Issued in 19.02.2015");
		AccountsTableDataStructure accountsTableDataStructure = 
				new AccountsTableDataStructure(account);
		this.accounts.add(accountsTableDataStructure);
		Account anotherAccount = new Account("PolishBank Card", 
				plasticCard, new Money(uah, 1457, 87), "Issued in 23.02.2015");
		AccountsTableDataStructure anotherAccountsTableDataStructure = 
				new AccountsTableDataStructure(anotherAccount);
		this.accounts.add(anotherAccountsTableDataStructure);
	}

	private String getAccountCommentsFieldName() {
		return "comments";
	}

	private String getAccountNameFieldName() {
		return "name";
	}

	private String getAccountRestFieldName() {
		return "rest";
	}
	
	private String getAccountCurrencyCodeFieldName() {
		return "currencyCode";
	}

	private String getAccountTypeFieldName() {
		return "type";
	}

	private String getColumnNameForAccountComments() {
		return "Comments";
	}

	private String getColumnNameForAccountName() {
		return "Name";
	}

	private String getColumnNameForAccountRest() {
		return "Rest";
	}

	private String getColumnNameForAccountCurrencyCode() {
		return "Currency code";
	}

	private String getColumnNameForAccountType() {
		return "Type";
	}

	public TableView<AccountsTableDataStructure> getTable() {
		TableView<AccountsTableDataStructure> tableView = 
				new TableView<AccountsTableDataStructure>();
		TableColumn<AccountsTableDataStructure, String> name = 
				new TableColumn<AccountsTableDataStructure, String>(
						getColumnNameForAccountName());
		name.setCellValueFactory(
				new PropertyValueFactory<AccountsTableDataStructure, String>(
						getAccountNameFieldName()));
		TableColumn<AccountsTableDataStructure, String> type = 
				new TableColumn<AccountsTableDataStructure, String>(
						getColumnNameForAccountType());
		type.setCellValueFactory(
				new PropertyValueFactory<AccountsTableDataStructure, String>(
						getAccountTypeFieldName()));
		TableColumn<AccountsTableDataStructure, String> rest = 
				new TableColumn<AccountsTableDataStructure, String>(
						getColumnNameForAccountRest());
		rest.setCellValueFactory(
				new PropertyValueFactory<AccountsTableDataStructure, String>(
						getAccountRestFieldName()));
		TableColumn<AccountsTableDataStructure, String> currencyCode = 
				new TableColumn<AccountsTableDataStructure, String>(
						getColumnNameForAccountCurrencyCode());
		currencyCode.setCellValueFactory(
				new PropertyValueFactory<AccountsTableDataStructure, String>(
						getAccountCurrencyCodeFieldName()));
		TableColumn<AccountsTableDataStructure, String> comments = 
				new TableColumn<AccountsTableDataStructure, String>(
						getColumnNameForAccountComments());
		comments.setCellValueFactory(
				new PropertyValueFactory<AccountsTableDataStructure, String>(
						getAccountCommentsFieldName()));

		fillAccountsWithTestData();

		tableView.getColumns().add(name);
		tableView.getColumns().add(type);
		tableView.getColumns().add(rest);
		tableView.getColumns().add(currencyCode);
		tableView.getColumns().add(comments);
		tableView.setItems(this.accounts);
		
		return tableView;
	}
}

package com.yourmoneysaver.javafxui;

import java.util.List;

import com.yourmoneysaver.exceptions.ArgumentIsNullException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AccountsTable {
	private ObservableList<AccountsTableDataStructure> accountsData;
	
	private AccountsTable() {
		
	}
	
	public static AccountsTable create(
			List<AccountsTableDataStructure> accountsData) {
		AccountsTable accountsTable = new AccountsTable();
		accountsTable.setAccountsData(
				FXCollections.observableArrayList(accountsData));
		return accountsTable;
	}

	private void setAccountsData(
			ObservableList<AccountsTableDataStructure> accountsData) {
		if(accountsData == null) {
			throw new ArgumentIsNullException("accountsData");
		}
		this.accountsData = accountsData;
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

		tableView.getColumns().add(name);
		tableView.getColumns().add(type);
		tableView.getColumns().add(rest);
		tableView.getColumns().add(currencyCode);
		tableView.getColumns().add(comments);
		tableView.setItems(this.accountsData);
		
		return tableView;
	}
}

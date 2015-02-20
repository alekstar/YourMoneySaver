package javaFXUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import YourMoneySaver.Account;
import YourMoneySaver.AccountType;
import YourMoneySaver.Currency;
import YourMoneySaver.Money;

public class AccountsTable {
	private final ObservableList<Account> accounts = FXCollections
	        .observableArrayList();

	private void fillAccountsWithTestData() {
		Currency uah = new Currency("Ukrainian hryvnia", "UAH", "₴");
		AccountType plasticCard = new AccountType("Пластиковая карта");
		this.accounts.add(new Account("Карта ПриватБанка", plasticCard,
		        new Money(uah, 150, 45), "Выдана 19.02.2015"));
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

	private String getAccountTypeFieldName() {
		return "accountType";
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

	private String getColumnNameForAccountType() {
		return "Type";
	}

	public TableView<Account> getTable() {
		TableView<Account> tableView = new TableView<Account>();

		TableColumn<Account, String> name = new TableColumn<Account, String>(
				getColumnNameForAccountName());
		name.setCellValueFactory(new PropertyValueFactory<Account, String>(
		        getAccountNameFieldName()));
		TableColumn<Account, String> type = new TableColumn<Account, String>(
		        getColumnNameForAccountType());
		type.setCellValueFactory(new PropertyValueFactory<Account, String>(
		        getAccountTypeFieldName()));
		TableColumn<Account, String> rest = new TableColumn<Account, String>(
		        getColumnNameForAccountRest());
		rest.setCellValueFactory(new PropertyValueFactory<Account, String>(
		        getAccountRestFieldName()));
		TableColumn<Account, String> comments = new TableColumn<Account, String>(
		        getColumnNameForAccountComments());
		comments.setCellValueFactory(new PropertyValueFactory<Account, String>(
		        getAccountCommentsFieldName()));

		fillAccountsWithTestData();

		tableView.getColumns().add(name);
		tableView.getColumns().add(type);
		tableView.getColumns().add(rest);
		tableView.getColumns().add(comments);
		tableView.setItems(this.accounts);

		return tableView;
	}
}

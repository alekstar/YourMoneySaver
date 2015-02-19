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
	private final ObservableList<Account> accounts = 
			FXCollections.observableArrayList();
	
	private void fillAccountsWithTestData() {
		Currency uah = new Currency("Украинская гривня", "UAH");
		AccountType plasticCard = new AccountType("Пластиковая карта");
		this.accounts.add(
				new Account(
						"Карта ПриватБанка", 
						plasticCard, 
						new Money(uah, 150, 45), 
						"Выдана 19.02.2015"));
	}
	
	public TableView<Account> getTable() {
		TableView<Account> tableView = new TableView<Account>();
		
		TableColumn<Account, String> name = 
				new TableColumn<Account, String>("Name");
		name.setCellValueFactory(
				new PropertyValueFactory<Account, String>("name"));
		TableColumn<Account, String> type = 
				new TableColumn<Account, String>("Type");
		type.setCellValueFactory(
				new PropertyValueFactory<Account, String>("accountType"));
		TableColumn<Account, String> rest = 
				new TableColumn<Account, String>("Rest");
		rest.setCellValueFactory(
				new PropertyValueFactory<Account, String>("rest"));
		TableColumn<Account, String> comments = 
				new TableColumn<Account, String>("Comments");
		comments.setCellValueFactory(
				new PropertyValueFactory<Account, String>("comments"));

		fillAccountsWithTestData();
		
		tableView.getColumns().add(name);
		tableView.getColumns().add(type);
		tableView.getColumns().add(rest);
		tableView.getColumns().add(comments);
		tableView.setItems(this.accounts);
		
		return tableView;
	}
}

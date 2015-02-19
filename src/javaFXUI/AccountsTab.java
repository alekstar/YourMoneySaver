package javaFXUI;

import YourMoneySaver.Account;
import YourMoneySaver.AccountType;
import YourMoneySaver.Currency;
import YourMoneySaver.Money;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class AccountsTab {
	
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
	
	private TableView<Account> getAccountsTable() {
		TableView<Account> tableView = new TableView<Account>();
		
		TableColumn<Account, String> name = 
				new TableColumn<Account, String>("Name");
		name.setCellValueFactory(
				new PropertyValueFactory<Account, String>("name"));
		TableColumn type = new TableColumn("Type");
		type.setCellValueFactory(
				new PropertyValueFactory<Account, String>("accountType"));
		TableColumn rest = new TableColumn("Rest");
		rest.setCellValueFactory(
				new PropertyValueFactory<Account, String>("rest"));
		TableColumn comments = new TableColumn("Comments");
		comments.setCellValueFactory(
				new PropertyValueFactory<Account, String>("comments"));

		fillAccountsWithTestData();
		
		tableView.getColumns().addAll(name, type, rest, comments);
		tableView.setItems(this.accounts);
		
		return tableView;
	}
	
	public Tab getTab() {
	    Tab accounts = new Tab();
		accounts.setText("Accounts");
		accounts.setClosable(false);
		VBox gridPane = new VBox();
		gridPane.getChildren().add(getAccountsTable());
		accounts.setContent(gridPane);
	    return accounts;
    }
}

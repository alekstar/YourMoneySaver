package javaFXUI;
import YourMoneySaver.*;

import com.sun.javafx.geom.Rectangle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private final ObservableList<Account> accounts = 
			FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) {

		TabPane mainPanel = getMainPanel();
		
		StackPane root = new StackPane();
		root.getChildren().add(mainPanel);

		Scene mainWindow = new Scene(root, 600, 500);

		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(mainWindow);
		primaryStage.setResizable(false);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	private Button getHelloWorldButton() {
	    Button button = new Button();
		button.setText("Say 'Hello World'");
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				StackPane secondWindow = new StackPane();
				Scene scene = new Scene(secondWindow, 300, 250);
				Stage stage = new Stage();
				stage.setTitle("Another window!");
				stage.setScene(scene);
				stage.show();
			}
		});
		return button;
    }

	private TabPane getMainPanel() {
	    TabPane mainPanel = new TabPane();
		
		Tab accounts = getAccountTab();
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

	private Tab getAccountTab() {
	    Tab accounts = new Tab();
		accounts.setText("Accounts");
		accounts.setClosable(false);
		GridPane gridPane = new GridPane();
		gridPane.addRow(1, getAccountsTable());
		accounts.setContent(gridPane);
	    return accounts;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
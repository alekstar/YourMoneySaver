package javaFXUI;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class AccountsTab {
	
	public Tab getTab() {
	    Tab accounts = new Tab();
		accounts.setText("Accounts");
		accounts.setClosable(false);
		VBox gridPane = new VBox();
		AccountsTable accountsTable = new AccountsTable();
		gridPane.getChildren().add(accountsTable.getTable());
		accounts.setContent(gridPane);
	    return accounts;
    }
}

package main.javaFXUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class AccountOperationsToolBox {
	private HBox box;
	
	private int getNiceSpacing() {
	    return 10;
    }
	
	private Insets getInsideOffsets() {
	    return new Insets(10, 0, 0, 0);
    }

	private Button getDeleteAccountButton() {
	    Button deleteAccountButton = new Button();
		deleteAccountButton.setText(getDeleteAccountButtonText());
	    return deleteAccountButton;
    }

	private String getDeleteAccountButtonText() {
	    return "Delete account";
    }

	private Button getAddAccountButton() {
	    Button addAccountButton = new Button();
		addAccountButton.setText(getAddAccountButtonText());
	    return addAccountButton;
    }

	private String getAddAccountButtonText() {
	    return "Add account";
    }
	
	public HBox getHBox() {
	    return this.box;
	}
	
	public AccountOperationsToolBox() {
		this.box = new HBox();
		defineParameters();
		addButtonsToBox();
	}

	private void defineParameters() {
	    box.setPadding(getInsideOffsets());
		box.setSpacing(getNiceSpacing());
    }

	private void addButtonsToBox() {
	    Button addAccountButton = getAddAccountButton();
		box.getChildren().add(addAccountButton);
		Button deleteAccountButton = getDeleteAccountButton();
		box.getChildren().add(deleteAccountButton);
    }
}

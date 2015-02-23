package com.yourmoneysaver.javafxui;

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

	private Button getRemoveAccountButton() {
		return new Button(getRemoveAccountButtonText());
    }

	private String getRemoveAccountButtonText() {
	    return "Remove";
    }

	private Button getAddAccountButton() {
		return new Button(getAddAccountButtonText());
    }

	private String getAddAccountButtonText() {
	    return "Add";
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
	
	private Button getEditAccountButton() {
		return new Button(getEditAccountButtonText());
	}

	private String getEditAccountButtonText() {
		return "Edit";
	}

	private void addButtonsToBox() {
		box.getChildren().add(getAddAccountButton());
		box.getChildren().add(getEditAccountButton());
		box.getChildren().add(getRemoveAccountButton());
    }
}

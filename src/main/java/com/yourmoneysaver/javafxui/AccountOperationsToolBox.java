package com.yourmoneysaver.javafxui;

import com.yourmoneysaver.Account;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AccountOperationsToolBox {
	private HBox box;
	private TableView tableView;
	
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
	
	private class AddAccountButtonAction implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent arg0) {
			AccountsTableDataStructure selectedAccount = 
					(AccountsTableDataStructure) 
					getTableView().getSelectionModel().getSelectedItem();
			if(selectedAccount != null) {
				System.out.println(selectedAccount.getName() + " selected!");
				Stage stage = new Stage();
				StackPane root = new StackPane();
				Scene mainWindow = new Scene(root, 500, 500);
				stage.setScene(mainWindow);
				stage.show();
			}
		}
		
	}

	private Button getAddAccountButton() {
		Button button = new Button(getAddAccountButtonText());
		button.setOnMouseClicked(new AddAccountButtonAction());
		return button;
    }

	private String getAddAccountButtonText() {
	    return "Add";
    }
	
	public HBox getHBox() {
	    return this.box;
	}
	
	public HBox getBox() {
		return box;
	}

	public void setBox(HBox box) {
		if(box == null) {
			throw new IllegalArgumentException("Argument box is null.");
		}
		this.box = box;
	}

	public TableView getTableView() {
		return tableView;
	}

	public void setTableView(TableView tableView) {
		if(tableView == null) {
			throw new IllegalArgumentException("Argument tableView is null.");
		}
		this.tableView = tableView;
	}

	public AccountOperationsToolBox(TableView accountsTableView) {
		setBox(new HBox());
		setTableView(accountsTableView);
		defineParameters();
		addButtonsToBox();
	}

	private void defineParameters() {
	    getBox().setPadding(getInsideOffsets());
		getBox().setSpacing(getNiceSpacing());
    }
	
	private Button getEditAccountButton() {
		return new Button(getEditAccountButtonText());
	}

	private String getEditAccountButtonText() {
		return "Edit";
	}

	private void addButtonsToBox() {
		getBox().getChildren().add(getAddAccountButton());
		getBox().getChildren().add(getEditAccountButton());
		getBox().getChildren().add(getRemoveAccountButton());
    }
}

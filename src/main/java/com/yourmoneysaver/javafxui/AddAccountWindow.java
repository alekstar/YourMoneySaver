package com.yourmoneysaver.javafxui;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddAccountWindow {
	Stage parentWindow;
	Stage thisWindow;

	public AddAccountWindow(Stage parentWindow) {
		setParentWindow(parentWindow);
		initializeThisWindow();
	}

	private void initializeThisWindow() {
		Scene mainWindow = new Scene(new StackPane(), getWidth(), getHeight());
		Stage stage = new Stage();
		stage.setScene(mainWindow);
		stage.initOwner(getParentWindow());
		stage.initModality(Modality.WINDOW_MODAL);
		stage.setResizable(false);
		setThisWindow(stage);
	}

	private int getHeight() {
		return 500;
	}

	private int getWidth() {
		return 500;
	}
	
	public Stage getThisWindow() {
		return thisWindow;
	}

	public void setThisWindow(Stage thisWindow) {
		if(thisWindow == null) {
			throw new IllegalArgumentException("Argument thisWindow is null.");
		}
		this.thisWindow = thisWindow;
	}

	public Stage getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Stage parentWindow) {
		if(parentWindow == null) {
			throw new IllegalArgumentException(
					"Argument parentWindow is null.");
		}
		this.parentWindow = parentWindow;
	}
	
	public void showAndWait() {
		getThisWindow().showAndWait();
	}
}

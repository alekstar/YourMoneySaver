package com.yourmoneysaver.javafxui;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddAccountWindow {
	private Stage parentWindow;
	private Stage thisWindow;
	private StackPane rootPane;

	public AddAccountWindow(Stage parentWindow) {
		setParentWindow(parentWindow);
		initializeThisWindow();
		addControlsToThisWindow();
	}

	public StackPane getRootPane() {
		return rootPane;
	}

	private void setRootPane(StackPane rootPane) {
		if(rootPane == null) {
			throw new IllegalArgumentException("Argument rootPane is null.");
		}
		this.rootPane = rootPane;
	}

	private void initializeThisWindow() {
		setRootPane(new StackPane());
		setThisWindow(new Stage());
		Scene mainWindow = new Scene(getRootPane(), getWidth(), getHeight());
		getThisWindow().setScene(mainWindow);
		getThisWindow().initOwner(getParentWindow());
		getThisWindow().initModality(Modality.WINDOW_MODAL);
		getThisWindow().setResizable(false);
	}
	
	private Label getLabelInstance(String labelText) {
		return new Label(labelText);
	}
	
	private Label getNameFieldLabel() {
		return getLabelInstance(getNameFieldLabelText());
	}

	private String getNameFieldLabelText() {
		return "Name";
	}
	
	private TextField getNameTextField() {
		return new TextField(getNameFieldLabelText());
	}
	
	private void addControlsToThisWindow() {
		VBox mainPane = new VBox();
		mainPane.getChildren().add(getNameFieldLabel());
		mainPane.getChildren().add(getNameTextField());
		mainPane.setPadding(getMainPanePadding());
		getRootPane().getChildren().add(mainPane);
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

	private void setThisWindow(Stage thisWindow) {
		if(thisWindow == null) {
			throw new IllegalArgumentException("Argument thisWindow is null.");
		}
		this.thisWindow = thisWindow;
	}

	public Stage getParentWindow() {
		return parentWindow;
	}

	private void setParentWindow(Stage parentWindow) {
		if(parentWindow == null) {
			throw new IllegalArgumentException(
					"Argument parentWindow is null.");
		}
		this.parentWindow = parentWindow;
	}
	
	public void showAndWait() {
		getThisWindow().showAndWait();
	}
	
	private Insets getMainPanePadding() {
	    return new Insets(10, 10, 10, 10);
    }
}

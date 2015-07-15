package com.alekstar.yourmoneysaver.ui.javafxui.currenciestab.addwindow;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import com.alekstar.yourmoneysaver.database.CurrencyEntity;
import com.alekstar.yourmoneysaver.database.CurrencyEntityAtJpa;
import com.alekstar.yourmoneysaver.domain.exceptions.ArgumentIsNullException;
import com.alekstar.yourmoneysaver.ui.javafxui.Standarts;
import com.alekstar.yourmoneysaver.ui.javafxui.currenciestab.CurrenciesData;

public class AddCurrencyWindow {
    private CurrenciesData currenciesData;
    private Stage thisWindow;
    private Window parentWindow;
    private TextField name;
    private TextField isoCode;
    private TextField symbol;
    private TextField comments;

    protected AddCurrencyWindow(Window parentWindow,
            CurrenciesData currenciesData) {
        setCurrenciesData(currenciesData);
        setParentWindow(parentWindow);
        initializeTextFields();
        initializeThisWindow();
    }

    public static AddCurrencyWindow create(Window parentWindow,
            CurrenciesData currenciesData) {
        return new AddCurrencyWindow(parentWindow, currenciesData);
    }

    private TextField getName() {
        return name;
    }

    private void setName(TextField name) {
        this.name = name;
    }

    private TextField getIsoCode() {
        return isoCode;
    }

    private void setIsoCode(TextField isoCode) {
        this.isoCode = isoCode;
    }

    private TextField getSymbol() {
        return symbol;
    }

    private void setSymbol(TextField symbol) {
        this.symbol = symbol;
    }

    private TextField getComments() {
        return comments;
    }

    private void setComments(TextField comments) {
        this.comments = comments;
    }

    private Stage getThisWindow() {
        return thisWindow;
    }

    private void setThisWindow(Stage thisWindow) {
        if (thisWindow == null) {
            throw new ArgumentIsNullException("thisWindow");
        }
        this.thisWindow = thisWindow;
    }

    private Window getParentWindow() {
        return parentWindow;
    }

    private void setParentWindow(Window parentWindow) {
        if (parentWindow == null) {
            throw new ArgumentIsNullException("parentWindow");
        }
        this.parentWindow = parentWindow;
    }

    private CurrenciesData getCurrenciesData() {
        return currenciesData;
    }

    private void setCurrenciesData(CurrenciesData currenciesData) {
        this.currenciesData = currenciesData;
    }

    private void addControlsToPane(Pane pane) {
        VBox vBox = new VBox();
        vBox.getChildren().add(getName());
        vBox.getChildren().add(getIsoCode());
        vBox.getChildren().add(getSymbol());
        vBox.getChildren().add(getComments());
        vBox.setPadding(Standarts.defineMainPanelInsets());
        vBox.setSpacing(10);

        HBox hBox = new HBox();
        hBox.getChildren().add(defineAddButton());
        hBox.setPadding(Standarts.defineToolBoxInsets());
        vBox.getChildren().add(hBox);

        pane.getChildren().add(vBox);
    }

    private void initializeTextFields() {
        initializeNameTextField();
        initializeIsoCodeTextField();
        initializeSymbolTextField();
        initializeCommentsTextField();
    }

    private void initializeCommentsTextField() {
        TextField textField = new TextField();
        textField.setPromptText("Comments");
        setComments(textField);
    }

    private void initializeSymbolTextField() {
        TextField textField = new TextField();
        textField.setPromptText("Symbol");
        setSymbol(textField);
    }

    private void initializeIsoCodeTextField() {
        TextField textField = new TextField();
        textField.setPromptText("IsoCode");
        setIsoCode(textField);
    }

    private void initializeNameTextField() {
        TextField textField = new TextField();
        textField.setPromptText("Name");
        setName(textField);
    }

    public void createNewCurrency() {
        try {
            CurrencyEntity currencyEntity =
                    new CurrencyEntityAtJpa(getName().getText(), getIsoCode()
                            .getText(), getSymbol().getText(), getComments()
                            .getText());
            getCurrenciesData().save(currencyEntity);
            getThisWindow().close();
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
        }
    }

    private Button defineAddButton() {
        Button button = new Button("Add");
        AddButtonEventHandler eventHandler = new AddButtonEventHandler(this);
        button.setOnKeyPressed(eventHandler);
        button.setOnMouseClicked(eventHandler);
        return button;
    }

    private void initializeThisWindow() {
        Stage window = new Stage();
        StackPane stackPane = new StackPane();
        addControlsToPane(stackPane);
        Scene scene = new Scene(stackPane);
        window.setWidth(500);
        window.setScene(scene);
        window.initOwner(getParentWindow());
        window.initModality(Modality.WINDOW_MODAL);
        window.setResizable(false);
        window.setTitle("Add new currency");
        setThisWindow(window);
    }

    public void showAndWait() {
        getThisWindow().showAndWait();
    }

    public void close() {
        getThisWindow().close();
    }
}

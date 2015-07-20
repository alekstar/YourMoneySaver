package com.alekstar.yourmoneysaver.ui.javafx;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.alekstar.yourmoneysaver.domain.Cash;
import com.alekstar.yourmoneysaver.domain.AccountType;
import com.alekstar.yourmoneysaver.domain.Currency;

public class AccountsTab extends AbstractTab {

    private AccountsTab(Stage parentWindow) {
        super(parentWindow);
    }

    public static AccountsTab create(Stage parentWindow) {
        AccountsTab accountsTab = new AccountsTab(parentWindow);
        accountsTab.constructTab();
        return accountsTab;
    }

    @Override
    protected String defineName() {
        return "Accounts";
    }

    @Override
    public void constructTab() {
        VBox vBox = new VBox();
        AccountsTable accountsTable =
                AccountsTable.create(getTestingAccountsData());
        TableView<AccountsTableDataStructure> accountsTableView =
                accountsTable.getTableView();
        vBox.getChildren().add(accountsTableView);
        HBox accountOperationsToolBox =
                getAccountOperationsToolBox(accountsTableView);
        vBox.getChildren().add(accountOperationsToolBox);
        vBox.setPadding(getVBoxInsideOffsets());
        getTab().setContent(vBox);
    }

    private HBox getAccountOperationsToolBox(
            TableView<AccountsTableDataStructure> accountsTableView) {
        AccountOperationsToolBox accountOperationsToolBox =
                new AccountOperationsToolBox(accountsTableView,
                        getParentWindow());
        return accountOperationsToolBox.getHBox();
    }

    private ArrayList<AccountsTableDataStructure> getTestingAccountsData() {
        ArrayList<AccountsTableDataStructure> accountsData =
                new ArrayList<AccountsTableDataStructure>();
        Currency uah = new Currency("Ukrainian hryvnia", "UAH", "₴", null);
        AccountType plasticCard = new AccountType("Plastic card", null);
        Cash account =
                new Cash("SwedenBank Card", plasticCard, uah,
                        "Issued in 19.02.2015");
        accountsData.add(AccountsTableDataStructure.create(account));

        Cash anotherAccount =
                new Cash("PolishBank Card", plasticCard, uah,
                        "Issued in 23.02.2015");
        accountsData.add(AccountsTableDataStructure.create(anotherAccount));

        return accountsData;
    }

    private Insets getVBoxInsideOffsets() {
        return Standarts.defineMainPanelInsets();
    }
}

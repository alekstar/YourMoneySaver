package com.alekstar.yourmoneysaver.javafxui;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.alekstar.yourmoneysaver.Currency;

public class CurrenciesTab extends AbstractTab {
    private EntityManager entityManager;

    private CurrenciesTab(Stage parentWindow) {
        super(parentWindow);
        initializeEntityManager();
    }

    public static CurrenciesTab create(Stage parentWindow) {
        CurrenciesTab tab = new CurrenciesTab(parentWindow);
        tab.constructTab();
        return tab;
    }

    @Override
    protected String defineName() {
        return "Currencies";
    }

    private void initializeEntityManager() {
        entityManager = EntityManagerFactorySingleton.getEntityManager();
    }

    private EntityManager getEntityManager() {
        return this.entityManager;
    }

    private List<Currency> getAllCurrenciesFromBase() {
        Session session = getEntityManager().unwrap(Session.class);
        List<Object> listOfObjectsFromDataBase =
                session.createCriteria(Currency.class).list();
        List<Currency> currenciesList = new ArrayList<Currency>();
        for (Object currenctObject : listOfObjectsFromDataBase) {
            currenciesList.add((Currency) currenctObject);
        }
        return currenciesList;
    }

    private Node defineToolBox() {
        CurrenciesOperationsToolBox toolBox =
                CurrenciesOperationsToolBox.create();
        return toolBox.getBox();
    }

    @Override
    protected void constructTab() {
        VBox mainPanel = new VBox();
        CurrenciesTable currenciesTable =
                CurrenciesTable.create(getAllCurrenciesFromBase());
        mainPanel.getChildren().add(currenciesTable.getTableView());
        mainPanel.getChildren().add(defineToolBox());
        mainPanel.setPadding(Standarts.defineMainPanelInsets());
        getTab().setContent(mainPanel);
    }
}

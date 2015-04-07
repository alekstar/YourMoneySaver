package com.alekstar.yourmoneysaver.javafxui;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.alekstar.yourmoneysaver.Currency;

public class CurrenciesTab extends AbstractTab {
    private EntityManager entityManager;
    private CurrenciesTable table;
    private Pane mainPanel;

    private CurrenciesTab(Stage parentWindow) {
        super(parentWindow);
        initializeEntityManager();
    }

    public static CurrenciesTab create(Stage parentWindow) {
        CurrenciesTab tab = new CurrenciesTab(parentWindow);
        tab.constructTab();
        return tab;
    }

    private EntityManager getEntityManager() {
        return this.entityManager;
    }

    private CurrenciesTable getTable() {
        return this.table;
    }

    public Pane getMainPanel() {
        return this.mainPanel;
    }

    @Override
    protected String defineName() {
        return "Currencies";
    }

    @Override
    protected void constructTab() {
        initializeTable();
        initializeMainPanel();
        getTab().setContent(getMainPanel());
    }

    private void initializeTable() {
        this.table = CurrenciesTable.create(getAllCurrenciesFromBase());
    }

    private void initializeMainPanel() {
        this.mainPanel = new VBox();
        getMainPanel().getChildren().add(getTable().getTableView());
        getMainPanel().getChildren().add(defineToolBox());
        getMainPanel().setPadding(Standarts.defineMainPanelInsets());
    }

    public void refresh() {
        initializeTable();
    }

    private void initializeEntityManager() {
        entityManager = EntityManagerFactorySingleton.getEntityManager();
    }

    private List<Currency> getAllCurrenciesFromBase() {
        Session session = getEntityManager().unwrap(Session.class);
        List<?> listOfObjectsFromDataBase =
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
}

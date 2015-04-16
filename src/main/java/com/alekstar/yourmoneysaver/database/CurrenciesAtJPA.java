package com.alekstar.yourmoneysaver.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.alekstar.yourmoneysaver.CurrenciesContainer;
import com.alekstar.yourmoneysaver.Currency;

public class CurrenciesAtJPA implements CurrenciesContainer {
    private EntityManager entityManager;

    protected CurrenciesAtJPA(EntityManager entityManager) {
        setEntityManager(entityManager);
    }

    public static CurrenciesAtJPA create(EntityManager entityManager) {
        return new CurrenciesAtJPA(entityManager);
    }

    @Override
    public void save(Currency currency) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(currency);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        }

    }

    @Override
    public void remove(Currency currency) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(currency);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        }
    }

    @Override
    public List<Currency> loadAll() {
        Session session = getEntityManager().unwrap(Session.class);
        List<?> listOfObjectsFromDataBase =
                session.createCriteria(Currency.class).list();
        List<Currency> currenciesList = new ArrayList<Currency>();
        for (Object currenctObject : listOfObjectsFromDataBase) {
            currenciesList.add((Currency) currenctObject);
        }
        return currenciesList;
    }

    private EntityManager getEntityManager() {
        return entityManager;
    }

    private void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

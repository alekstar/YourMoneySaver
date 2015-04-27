package com.alekstar.yourmoneysaver.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.alekstar.yourmoneysaver.CurrenciesDataAccessObject;
import com.alekstar.yourmoneysaver.Currency;

public class CurrenciesAtJPA implements CurrenciesDataAccessObject {
    private EntityManager entityManager;

    protected CurrenciesAtJPA(EntityManager entityManager) {
        setEntityManager(entityManager);
    }

    public static CurrenciesAtJPA create(EntityManager entityManager) {
        return new CurrenciesAtJPA(entityManager);
    }

    @Override
    public void save(CurrencyEntity currencyEntity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(currencyEntity);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        }

    }

    @Override
    public void remove(CurrencyEntity currencyEntity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(currencyEntity);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        }
    }

    @Override
    public List<CurrencyEntity> loadAll() {
        Session session = getEntityManager().unwrap(Session.class);
        List<?> listOfObjectsFromDataBase =
                session.createCriteria(CurrencyEntity.class).list();
        List<CurrencyEntity> currenciesList = new ArrayList<CurrencyEntity>();
        for (Object currenctObject : listOfObjectsFromDataBase) {
            currenciesList.add((CurrencyEntity) currenctObject);
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

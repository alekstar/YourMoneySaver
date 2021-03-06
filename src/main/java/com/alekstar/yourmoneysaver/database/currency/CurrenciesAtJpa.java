package com.alekstar.yourmoneysaver.database.currency;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

public class CurrenciesAtJpa implements CurrenciesDataAccessObject {
    private EntityManager entityManager;

    protected CurrenciesAtJpa(EntityManager entityManager) {
        setEntityManager(entityManager);
    }

    public static CurrenciesAtJpa create(EntityManager entityManager) {
        return new CurrenciesAtJpa(entityManager);
    }

    @Override
    public void save(CurrencyEntity currencyEntity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(currencyEntity);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
            throw e;
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
            throw e;
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

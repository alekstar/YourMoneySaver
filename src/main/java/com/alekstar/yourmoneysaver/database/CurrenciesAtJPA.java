package com.alekstar.yourmoneysaver.database;

import java.util.List;

import javax.persistence.EntityManager;

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
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(Currency currency) {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(Currency currency) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Currency> loadAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Currency> loadAll(int from, int to) {
        // TODO Auto-generated method stub
        return null;
    }

    private EntityManager getEntityManager() {
        return entityManager;
    }

    private void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

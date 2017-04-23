package com.alekstar.yourmoneysaver.database.currency;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import java.util.List;

public class CurrenciesAtJpaWithLogger implements CurrenciesDataAccessObject {

    private Logger logger = Logger.getLogger(CurrenciesAtJpaWithLogger.class);

    private CurrenciesAtJpa currenciesAtJpa;

    public static CurrenciesDataAccessObject create(EntityManager entityManager) {
        return new CurrenciesAtJpaWithLogger(CurrenciesAtJpa.create(entityManager));
    }

    public CurrenciesAtJpaWithLogger(CurrenciesAtJpa currenciesAtJpa) {
        this.currenciesAtJpa = currenciesAtJpa;
    }

    @Override
    public void save(CurrencyEntity currencyEntity) {
        try {
            logger.debug("Saving currency " + currencyEntity);
            currenciesAtJpa.save(currencyEntity);
            logger.debug("Currency " + currencyEntity + " saved.");
        } catch (RuntimeException e) {
            logger.error("Currency " + currencyEntity + " have not been saved because of exception.", e);
            throw e;
        }
    }

    @Override
    public void remove(CurrencyEntity currencyEntity) {
    }

    @Override
    public List<CurrencyEntity> loadAll() {
        return null;
    }
}

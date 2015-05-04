package com.alekstar.yourmoneysaver;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.alekstar.yourmoneysaver.database.CurrenciesAtJpa;
import com.alekstar.yourmoneysaver.database.CurrencyEntity;
import com.alekstar.yourmoneysaver.database.CurrencyEntityAtJpa;

public class CurrenciesAtJpaTest {

    private String defineNameOfPersistenceUnit() {
        return "YourMoneySaverH2TestDataBase";
    }

    private CurrencyEntity createUSDCurrencyToDataBase(
            EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();
        Currency usd = new Currency("United States dollar", "USD", "$", null);
        CurrencyEntity usdEntity = new CurrencyEntityAtJpa(usd);
        try {
            CurrenciesDataAccessObject currenciesDataAccessObject =
                    CurrenciesAtJpa.create(entityManager);
            currenciesDataAccessObject.save(usdEntity);
            return usdEntity;
        } finally {
            entityManager.close();
        }
    }

    private CurrencyEntity readFirstCurrencyFromDataBase(
            EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();
        try {
            CurrenciesDataAccessObject currenciesDataAccessObject =
                    CurrenciesAtJpa.create(entityManager);

            List<CurrencyEntity> listOfCurrenciesEntities =
                    currenciesDataAccessObject.loadAll();
            return listOfCurrenciesEntities.get(0);
        } finally {
            entityManager.close();
        }
    }

    @Test
    public void shouldCreateUSDCurrency() {
        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory(defineNameOfPersistenceUnit());
        try {
            CurrencyEntity expected =
                    createUSDCurrencyToDataBase(entityManagerFactory);
            CurrencyEntity actual =
                    readFirstCurrencyFromDataBase(entityManagerFactory);
            assertEquals(expected, actual);
        } finally {
            entityManagerFactory.close();
        }
    }
}

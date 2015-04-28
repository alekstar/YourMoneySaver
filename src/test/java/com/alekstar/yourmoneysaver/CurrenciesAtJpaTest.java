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
    EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(defineNameOfPersistenceUnit());

    private String defineNameOfPersistenceUnit() {
        return "YourMoneySaverH2TestDataBase";
    }

    private CurrencyEntity createUSDCurrencyToDataBase() {
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

    private CurrencyEntity readFirstCurrencyFromDataBase() {
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
        try {
            CurrencyEntity expected = createUSDCurrencyToDataBase();
            CurrencyEntity actual = readFirstCurrencyFromDataBase();
            assertEquals(expected, actual);
        } finally {
            this.entityManagerFactory.close();
        }
    }
}

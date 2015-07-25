package com.alekstar.yourmoneysaver.database.currency;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.alekstar.yourmoneysaver.database.currency.CurrenciesAtJpa;
import com.alekstar.yourmoneysaver.database.currency.CurrenciesDataAccessObject;
import com.alekstar.yourmoneysaver.database.currency.CurrencyEntity;
import com.alekstar.yourmoneysaver.database.currency.CurrencyEntityAtJpa;
import com.alekstar.yourmoneysaver.domain.Currency;

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

    private CurrencyEntity readFirstCurrencyFromDataBaseForEditing(
            CurrenciesDataAccessObject currenciesDataAccessObject) {
        List<CurrencyEntity> listOfCurrenciesEntities =
                currenciesDataAccessObject.loadAll();
        return listOfCurrenciesEntities.get(0);
    }

    private void changeCommentsAndNameOfUah(
            CurrencyEntity uahEntityThatHaveToBeRead) {
        Currency uahThatHaveToBeEdited =
                ((CurrencyEntityAtJpa) uahEntityThatHaveToBeRead).getCurrency();
        uahThatHaveToBeEdited.setComments("This comment was edited.");
        uahThatHaveToBeEdited
                .setName("New name of Ukrainian national currency.");
    }

    private void saveCurrencyToDataBase(
            CurrencyEntity uahEntityThatHaveToBeCreated,
            CurrenciesDataAccessObject currenciesDataAccessObject) {
        currenciesDataAccessObject.save(uahEntityThatHaveToBeCreated);
    }

    @Test
    public void afterChangingOfInternalCurrencyInstanceOfCurrencyEntityAtJpaOnSaveChangesShouldBeInDataBase() {
        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory(defineNameOfPersistenceUnit());
        try {
            CurrencyEntityAtJpa uahEntityThatHaveToBeCreated =
                    new CurrencyEntityAtJpa("Ukrainian hrivnya", "UAH", "₴",
                            null);
            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();
            try {
                CurrenciesDataAccessObject currenciesDataAccessObject =
                        CurrenciesAtJpa.create(entityManager);

                saveCurrencyToDataBase(uahEntityThatHaveToBeCreated,
                        currenciesDataAccessObject);

                CurrencyEntity uahEntityThatHaveToBeRead =
                        readFirstCurrencyFromDataBaseForEditing(currenciesDataAccessObject);
                changeCommentsAndNameOfUah(uahEntityThatHaveToBeRead);
                saveCurrencyToDataBase(uahEntityThatHaveToBeRead,
                        currenciesDataAccessObject);
                CurrencyEntityAtJpa uahEntityThatHaveToBeReadAfterChangesOfCurrency =
                        (CurrencyEntityAtJpa) readFirstCurrencyFromDataBase(entityManagerFactory);
                Currency actual =
                        uahEntityThatHaveToBeReadAfterChangesOfCurrency
                                .getCurrency();
                Currency expected =
                        new Currency(
                                "New name of Ukrainian national currency.",
                                "UAH", "₴", "This comment was edited.");
                assertEquals(expected, actual);

            } finally {
                entityManager.close();
            }
        } finally {
            entityManagerFactory.close();
        }
    }
}

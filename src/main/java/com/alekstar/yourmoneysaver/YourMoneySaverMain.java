package com.alekstar.yourmoneysaver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class YourMoneySaverMain {

    public static void main(String[] args) {
        Currency uah = new Currency("Ukrainian hrivnya", "UAH", "₴", null);
        Currency usd = new Currency("United States dollar", "USD", "$", null);
        Currency rub = new Currency("Russian ruble", "RUB", "₽", null);

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("YourMoneySaverTest");
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();
        try {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(uah);
                entityManager.persist(usd);
                entityManager.persist(rub);
                entityManager.getTransaction().commit();
            } catch (RuntimeException e) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}

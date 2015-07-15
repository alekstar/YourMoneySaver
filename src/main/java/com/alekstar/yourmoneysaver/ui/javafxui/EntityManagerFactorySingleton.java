package com.alekstar.yourmoneysaver.ui.javafxui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private static EntityManagerFactory entityManagerFactory;

    private EntityManagerFactorySingleton() {

    }

    public static EntityManagerFactory getInstance() {
        if (entityManagerFactory == null) {
            entityManagerFactory =
                    Persistence
                            .createEntityManagerFactory("YourMoneySaverTest");
        }
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        return getInstance().createEntityManager();
    }

    public static void close() {
        try {
            entityManagerFactory.close();
        } catch (IllegalStateException e) {
            System.err.println("EntityManagerFactory is already closed.");
        }
    }
}

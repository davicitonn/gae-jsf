package com.example.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {

    private static final EntityManagerFactory emfInstance
            = Persistence.createEntityManagerFactory("gaePU");

    private EMF() {
    }

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}

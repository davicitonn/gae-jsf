package com.example.controller;

import com.example.gae.entity.Servicio;
import com.example.persistence.EMF;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Named("controlador")
@ViewScoped
public class Controlador implements Serializable {

    private String saludo = "hola a todos";
    private Servicio servicio = new Servicio();

    public Controlador() {
    }
    
    public void nuevo() {
        servicio = new Servicio();
    }

    public void guardar() {
        EntityManager em = EMF.get().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(servicio);
            tx.commit();
        } finally {
            em.close();
        }
    }
    
    public List<Servicio> datos() {
        EntityManager em = EMF.get().createEntityManager();
        TypedQuery<Servicio> query = em.createQuery("SELECT s FROM Servicio s", Servicio.class);
        return query.getResultList();
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

}

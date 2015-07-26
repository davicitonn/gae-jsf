package cl.hardcybersoft.learning.gae.controller;

import cl.hardcybersoft.learning.gae.entity.Servicio;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ViewScoped
@ManagedBean(name = "web")
public class Web implements Serializable {

    private String saludo = "Holi a todos !!!";
    private Servicio entity = new Servicio();

    public Web() {
    }
    
    public void guardar() {
        EntityManagerFactory emf    = Persistence.createEntityManagerFactory("gaePU");
        EntityManager em            = emf.createEntityManager();
        try{
            em.persist(entity);
            entity = new Servicio();
        } finally {
            em.close();            
        }
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public Servicio getEntity() {
        return entity;
    }

    public void setEntity(Servicio entity) {
        this.entity = entity;
    }
    
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Web web = (Web) o;

        return saludo.equals(web.saludo);

    }

    @Override
    public int hashCode() {
        return saludo.hashCode();
    }

    @Override
    public String toString() {
        return "Web{" +
                "saludo='" + saludo + '\'' +
                '}';
    }
}

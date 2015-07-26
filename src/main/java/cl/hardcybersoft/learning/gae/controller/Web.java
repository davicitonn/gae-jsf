package cl.hardcybersoft.learning.gae.controller;

import javax.inject.Named;
import java.io.Serializable;

@Named(value = "web")
public class Web implements Serializable {

    private String saludo = "Holi a todos !!!";

    public Web() {
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
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

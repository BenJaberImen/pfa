package tn.essat.projet1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Metier {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetier;
private String titreMetier;

    public Metier() {
    }

    public Metier(Integer idMetier, String titreMetier) {
        this.idMetier = idMetier;
        this.titreMetier = titreMetier;
    }

    public Integer getIdMetier() {
        return idMetier;
    }

    public void setIdMetier(Integer idMetier) {
        this.idMetier = idMetier;
    }

    public String getTitreMetier() {
        return titreMetier;
    }

    public void setTitreMetier(String titreMetier) {
        this.titreMetier = titreMetier;
    }

    @Override
    public String toString() {
        return "Metier{" +
                "idMetier=" + idMetier +
                ", titreMetier='" + titreMetier + '\'' +
                '}';
    }
}

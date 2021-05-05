package tn.essat.projet1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entretien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEntretient;
    private String dateEntretient;

    public Entretien() {
    }

    public Entretien(Integer idEntretient, String dateEntretient) {
        this.idEntretient = idEntretient;
        this.dateEntretient = dateEntretient;
    }

    public Integer getIdEntretient() {
        return idEntretient;
    }

    public void setIdEntretient(Integer idEntretient) {
        this.idEntretient = idEntretient;
    }

    public String getDateEntretient() {
        return dateEntretient;
    }

    public void setDateEntretient(String dateEntretient) {
        this.dateEntretient = dateEntretient;
    }

    @Override
    public String toString() {
        return "Entretien{" +
                "idEntretient=" + idEntretient +
                ", dateEntretient='" + dateEntretient + '\'' +
                '}';
    }
}

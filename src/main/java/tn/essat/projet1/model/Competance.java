package tn.essat.projet1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Competance {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompetance;
private String domaineCompetance;

    public Competance() {
    }

    public Competance(Integer idCompetance, String domaineCompetance) {
        this.idCompetance = idCompetance;
        this.domaineCompetance = domaineCompetance;
    }

    public Integer getIdCompetance() {
        return idCompetance;
    }

    public void setIdCompetance(Integer idCompetance) {
        this.idCompetance = idCompetance;
    }

    public String getDomaineCompetance() {
        return domaineCompetance;
    }

    public void setDomaineCompetance(String domaineCompetance) {
        this.domaineCompetance = domaineCompetance;
    }

    @Override
    public String toString() {
        return "Competance{" +
                "idCompetance=" + idCompetance +
                ", domaineCompetance='" + domaineCompetance + '\'' +
                '}';
    }
}

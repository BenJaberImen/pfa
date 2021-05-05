package tn.essat.projet1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experience {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer idExperience;
private String anneExperience;

    public Experience() {
    }

    public Experience(Integer idExperience, String anneExperience) {
        this.idExperience = idExperience;
        this.anneExperience = anneExperience;
    }

    public Integer getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(Integer idExperience) {
        this.idExperience = idExperience;
    }

    public String getAnneExperience() {
        return anneExperience;
    }

    public void setAnneExperience(String anneExperience) {
        this.anneExperience = anneExperience;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "idExperience=" + idExperience +
                ", anneExperience='" + anneExperience + '\'' +
                '}';
    }
}

package tn.essat.projet1.model;

import javax.persistence.*;

@Entity
public class Specialite {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSpecialite;
private String dommaine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idMetier")
    private Metier metier;

    public Specialite() {
    }

    public Specialite(Integer idSpecialite, String dommaine, Metier metier) {
        this.idSpecialite = idSpecialite;
        this.dommaine = dommaine;
        this.metier = metier;
    }

    public Integer getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(Integer idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public String getDommaine() {
        return dommaine;
    }

    public void setDommaine(String dommaine) {
        this.dommaine = dommaine;
    }

    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }

    @Override
    public String toString() {
        return "Specialite{" +
                "idSpecialite=" + idSpecialite +
                ", dommaine='" + dommaine + '\'' +
                ", metier=" + metier +
                '}';
    }
}

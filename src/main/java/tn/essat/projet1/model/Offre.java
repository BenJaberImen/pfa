package tn.essat.projet1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offre {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
private int nombreTotaleCondidatDemande;
 private int disponibilite;
private String dateLancmentOffre;
private  String dateExposition;

    public Offre() {
    }

    public Offre(Integer id, int nombreTotaleCondidatDemande, int disponibilite, String dateLancmentOffre, String dateExposition) {
        this.id = id;
        this.nombreTotaleCondidatDemande = nombreTotaleCondidatDemande;
        this.disponibilite = disponibilite;
        this.dateLancmentOffre = dateLancmentOffre;
        this.dateExposition = dateExposition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNombreTotaleCondidatDemande() {
        return nombreTotaleCondidatDemande;
    }

    public void setNombreTotaleCondidatDemande(int nombreTotaleCondidatDemande) {
        this.nombreTotaleCondidatDemande = nombreTotaleCondidatDemande;
    }

    public int getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getDateLancmentOffre() {
        return dateLancmentOffre;
    }

    public void setDateLancmentOffre(String dateLancmentOffre) {
        this.dateLancmentOffre = dateLancmentOffre;
    }

    public String getDateExposition() {
        return dateExposition;
    }

    public void setDateExposition(String dateExposition) {
        this.dateExposition = dateExposition;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", nombreTotaleCondidatDemande=" + nombreTotaleCondidatDemande +
                ", disponibilite=" + disponibilite +
                ", dateLancmentOffre='" + dateLancmentOffre + '\'' +
                ", dateExposition='" + dateExposition + '\'' +
                '}';
    }
}

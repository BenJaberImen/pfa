package tn.essat.projet1.model;

import javax.persistence.*;

@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDemande;
    private String dateDemande;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private  Offre offre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private  Entretien entretien;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCondidat")
    private Condidat condidat;


    public Demande() {
    }

    public Demande(Integer idDemande, String dateDemande, Condidat condidat, Offre offre, Entretien entretien) {
        this.idDemande = idDemande;
        this.dateDemande = dateDemande;
        this.condidat = condidat;
        this.offre = offre;
        this.entretien = entretien;
    }

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public String getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(String dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Condidat getCondidat() {
        return condidat;
    }

    public void setCondidat(Condidat condidat) {
        this.condidat = condidat;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public Entretien getEntretien() {
        return entretien;
    }

    public void setEntretien(Entretien entretien) {
        this.entretien = entretien;
    }

    @Override
    public String toString() {
        return "Demande{" +
                "idDemande=" + idDemande +
                ", dateDemande='" + dateDemande + '\'' +
                ", condidat=" + condidat +
                ", offre=" + offre +
                ", entretien=" + entretien +
                '}';
    }
}

package tn.essat.projet1.model;


import javax.persistence.*;
import java.util.List;
@Entity

public class Recruteur extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  idRecruteur;
    @OneToMany(mappedBy = "recruteur",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Offre> offres;

    public Recruteur() {
    }

    public Recruteur(Integer idUser, String firstName, String lastName, String adress, String email, String numTel, String role, Integer idRecruteur, List<Offre> offres) {
        super(idUser, firstName, lastName, adress, email, numTel, role);
        this.idRecruteur = idRecruteur;
        this.offres = offres;
    }

    public Recruteur(String firstName, String lastName, String adress, String email, String numTel, Integer idRecruteur, List<Offre> offres) {
        super(firstName, lastName, adress, email, numTel);
        this.idRecruteur = idRecruteur;
        this.offres = offres;

    }

    public Integer getIdRecruteur() {
        return idRecruteur;
    }

    public void setIdRecruteur(Integer idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    public List<Offre> getOffres() {
        return offres;
    }

    public void setOffres(List<Offre> offres) {
        this.offres = offres;
    }

    @Override
    public String toString() {
        return "Recruteur{" +
                "idRecruteur=" + idRecruteur +
                ", offres=" + offres +
                '}';
    }
}

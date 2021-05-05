package tn.essat.projet1.model;

import javax.persistence.*;

@Entity
public class Societe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String adress;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idRecruteur")
    private Recruteur recruteur;

    public Societe() {
    }

    public Societe(Integer id, String nom, String adress, Recruteur recruteur) {
        this.id = id;
        this.nom = nom;
        this.adress = adress;
        this.recruteur = recruteur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Recruteur getRecruteur() {
        return recruteur;
    }

    public void setRecruteur(Recruteur recruteur) {
        this.recruteur = recruteur;
    }

    @Override
    public String toString() {
        return "Societe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adress='" + adress + '\'' +
                ", recruteur=" + recruteur +
                '}';
    }
}

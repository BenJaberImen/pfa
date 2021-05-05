package tn.essat.projet1.model;

import javax.persistence.*;
import java.util.List;

public class Condidat extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCondidat;
    private int age;
    private String sexe;
    private String niveauEtude;
    private String Formation;
    private String anneDiplome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idSpecialite")
    private Specialite specialite;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idCompetance")
    private Competance competance;

    @OneToMany(mappedBy = "condidat",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Experience> experiences;

    public Condidat() {
    }

    public Condidat(Integer idUser, String firstName, String lastName, String adress, String email, String numTel, String role, Integer idCondidat, int age, String sexe, String niveauEtude, String formation, String anneDiplome, Specialite specialite, Competance competance, List<Experience> experiences) {
        super(idUser, firstName, lastName, adress, email, numTel, role);
        this.idCondidat = idCondidat;
        this.age = age;
        this.sexe = sexe;
        this.niveauEtude = niveauEtude;
        Formation = formation;
        this.anneDiplome = anneDiplome;
        this.specialite = specialite;
        this.competance = competance;
        this.experiences = experiences;
    }

    public Condidat(String firstName, String lastName, String adress, String email, String numTel, Integer idCondidat, int age, String sexe, String niveauEtude, String formation, String anneDiplome, Specialite specialite, Competance competance, List<Experience> experiences) {
        super(firstName, lastName, adress, email, numTel);
        this.idCondidat = idCondidat;
        this.age = age;
        this.sexe = sexe;
        this.niveauEtude = niveauEtude;
        Formation = formation;
        this.anneDiplome = anneDiplome;
        this.specialite = specialite;
        this.competance = competance;
        this.experiences = experiences;
    }

    public Integer getIdCondidat() {
        return idCondidat;
    }

    public void setIdCondidat(Integer idCondidat) {
        this.idCondidat = idCondidat;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Competance getCompetance() {
        return competance;
    }

    public void setCompetance(Competance competance) {
        this.competance = competance;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public String getNiveauEtude() {
        return niveauEtude;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    public String getFormation() {
        return Formation;
    }

    public void setFormation(String formation) {
        Formation = formation;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public String getAnneDiplome() {
        return anneDiplome;
    }

    public void setAnneDiplome(String anneDiplome) {
        this.anneDiplome = anneDiplome;
    }

    @Override
    public String toString() {
        return "Condidat{" +
                "idCondidat=" + idCondidat +
                ", age=" + age +
                ", sexe='" + sexe + '\'' +
                ", niveauEtude='" + niveauEtude + '\'' +
                ", Formation='" + Formation + '\'' +
                ", anneDiplome='" + anneDiplome + '\'' +
                ", specialite=" + specialite +
                ", competance=" + competance +
                ", experiences=" + experiences +
                '}';
    }
}

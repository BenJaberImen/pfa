package tn.essat.projet1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idAdmin;

    public Admin() {
    }

    public Admin(Integer idUser, String firstName, String lastName, String adress, String email, String numTel, String role, Integer idAdmin) {
        super(idUser, firstName, lastName, adress, email, numTel, role);
        this.idAdmin = idAdmin;
    }

    public Admin(String firstName, String lastName, String adress, String email, String numTel, Integer idAdmin) {
        super(firstName, lastName, adress, email, numTel);
        this.idAdmin = idAdmin;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idAdmin=" + idAdmin +
                '}';
    }
}

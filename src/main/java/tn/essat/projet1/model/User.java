package tn.essat.projet1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String firstName,lastName,adress,email,numTel,role;

    public User() {
    }

    public User(Integer idUser, String firstName, String lastName, String adress, String email, String numTel, String role) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
        this.numTel = numTel;
    }

    public User(String firstName, String lastName, String adress, String email, String numTel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
        this.numTel = numTel;
    }

    public Integer getId() {
        return idUser;
    }

    public void setId(Long id) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", numTel='" + numTel + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

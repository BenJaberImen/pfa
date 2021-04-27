package tn.essat.projet1.model;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idRole;
    @Enumerated(EnumType.STRING)
    private ERole role;

    public Role() {
    }

    public Role(Integer idRole, ERole role) {
        this.idRole = idRole;
        this.role = role;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", role=" + role +
                '}';
    }
}

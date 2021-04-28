package tn.essat.projet1.Response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type="Bearer";
    private Integer id;
    private List<String> roles;
    private String firstName;
    private String lastName;


    public JwtResponse() {
    }

    public JwtResponse(String token,Integer id, List<String> roles,String firstName, String lastName) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

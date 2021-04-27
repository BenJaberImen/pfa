package tn.essat.projet1.Response;

public class Jwt {
    private String token;
    private String type="Bearer";
    private Integer id;
    private String firstName;
    private String lastName;

    public Jwt() {
    }

    public Jwt(String token, String type, Integer id, String firstName, String lastName) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.firstName = firstName;


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

}

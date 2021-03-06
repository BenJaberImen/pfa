package tn.essat.projet1.securite.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tn.essat.projet1.model.Compte;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID=1L;
    @JsonIgnore
    private final String password;
    private final Integer id;
    private final String login;
    private final Collection<? extends GrantedAuthority> authorities;
    private String firstname;
    private String lastname;

    public UserDetailsImpl(String password, Integer id, String login, Collection<? extends GrantedAuthority> authorities, String firstname, String lastname) {
        this.password = password;
        this.id = id;
        this.login = login;
        this.authorities = authorities;
        this.firstname = firstname;
        this.lastname = lastname;
    }
public static UserDetailsImpl build(Compte compte){
    List<GrantedAuthority> grantedAuthorities=compte.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRole().name())).collect(Collectors.toList());
    return new UserDetailsImpl(compte.getPassword(),compte.getIdCompte(),compte.getLogin(),grantedAuthorities,compte.getUser().getFirstName(),compte.getUser().getLastName());

}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl compte = (UserDetailsImpl) o;
        return Objects.equals(id,compte.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, id, login, authorities, firstname, lastname);
    }
}

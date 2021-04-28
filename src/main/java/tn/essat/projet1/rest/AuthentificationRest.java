package tn.essat.projet1.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.essat.projet1.Request.LoginRequest;
import tn.essat.projet1.Request.SingupRequest;
import tn.essat.projet1.Response.JwtResponse;
import tn.essat.projet1.Response.MessageResponse;
import tn.essat.projet1.model.Compte;
import tn.essat.projet1.model.ERole;
import tn.essat.projet1.model.Role;
import tn.essat.projet1.model.User;
import tn.essat.projet1.repository.IRoleRepo;
import tn.essat.projet1.repository.IUserRepo;
import tn.essat.projet1.securite.JwtUtil;
import tn.essat.projet1.securite.service.UserDetailsImpl;
import tn.essat.projet1.service.CompteService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/")
public class AuthentificationRest {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    CompteService compteService;
    @Autowired
    IUserRepo iUserRepo;
    @Autowired
    IRoleRepo iRoleRepo;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/signin")

    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.token(authentication);
        UserDetailsImpl userDetails=(UserDetailsImpl) authentication.getPrincipal();
        List<String> roles=userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,userDetails.getId(),roles,userDetails.getFirstname(),userDetails.getLastname()));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SingupRequest signUpRequest) {
        if (compteService.existBylogin(signUpRequest.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: login is already taken!")); }
        Compte compte=new Compte (signUpRequest.getLogin(),encoder.encode(signUpRequest.getPassword()),
           new User(signUpRequest.getFirstName(),signUpRequest.getLastName(),signUpRequest.getAdress(),signUpRequest.getEmail(),signUpRequest.getNumTel()));
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = iRoleRepo.findByRole(ERole.ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = iRoleRepo.findByRole(ERole.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = iRoleRepo.findByRole(ERole.CONDIDAT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = iRoleRepo.findByRole(ERole.RECRUTEUR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        compte.setRoles(roles);
        compteService.addCompte(compte);

        return ResponseEntity.ok(new MessageResponse("Account registered successfully!"));

    }









}









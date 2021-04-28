package tn.essat.projet1.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestRst {


        @GetMapping("/all")
        public String allAccess() {
            return "Public Content.";
        }

        @GetMapping("/user")
        @PreAuthorize("hasRole('ADMIN') or hasRole('CONDIDAT') or hasRole('RECRUTEUR')")
        public String userAccess() {
            return "User Content.";
        }

        @GetMapping("/admin")
        @PreAuthorize("hasRole('ADMIN')")
        public String adminAccess() {
            return "admin Board.";
        }

        @GetMapping("/condidat")
        @PreAuthorize("hasRole('CONDIDAT')")
        public String condidatAccess() {
            return "condidat Board.";
        }
    @GetMapping("/recruteur")
    @PreAuthorize("hasRole('RECRUTEUR')")
    public String recruteurAccess() {
        return "recruteur Board.";
    }
    }


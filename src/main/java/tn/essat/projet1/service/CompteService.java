package tn.essat.projet1.service;

import tn.essat.projet1.model.Compte;

public interface CompteService {
    Boolean existBylogin(String login);
    void addCompte(Compte compte);

}

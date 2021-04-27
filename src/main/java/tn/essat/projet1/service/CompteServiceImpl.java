package tn.essat.projet1.service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.essat.projet1.model.Compte;
import tn.essat.projet1.repository.ICompteRepo;

public class CompteServiceImpl implements CompteService{
    @Autowired
    ICompteRepo iCompteRepo;
    @Override
    public Boolean existBylogin(String login) {

        return iCompteRepo.existsByLogin(login);
    }

    @Override
    public void addCompte(Compte compte) {
        iCompteRepo.save(compte);

    }
}

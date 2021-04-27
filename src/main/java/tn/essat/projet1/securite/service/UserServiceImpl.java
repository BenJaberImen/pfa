package tn.essat.projet1.securite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import tn.essat.projet1.model.Compte;
import tn.essat.projet1.repository.ICompteRepo;

import javax.transaction.Transactional;

public class UserServiceImpl implements UserDetailsService {

    @Autowired
    ICompteRepo iCompteRepo;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Compte compte =iCompteRepo.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("utilisateur ne existe pas !!"+login)) ;
        return UserDetailsImpl.build(compte);
    }


}

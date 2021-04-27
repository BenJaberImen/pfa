package tn.essat.projet1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.essat.projet1.model.Compte;

import java.util.Optional;

public interface ICompteRepo extends JpaRepository<Compte,Integer> {

    Optional <Compte> findByLogin(String login);
    Boolean existsByLogin(String login);
}

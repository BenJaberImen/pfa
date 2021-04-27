package tn.essat.projet1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.essat.projet1.model.ERole;
import tn.essat.projet1.model.Role;

import java.util.Optional;

public interface IRoleRepo extends JpaRepository<Role,Integer> {
    Optional<Role> findByRole(ERole role);
}

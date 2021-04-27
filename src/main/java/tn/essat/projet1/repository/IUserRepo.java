package tn.essat.projet1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.essat.projet1.model.User;

public interface IUserRepo extends JpaRepository<User,Integer> {
}

package br.com.BudgetBuddy.repository;

import br.com.BudgetBuddy.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    List<User> findByActivedTrue();

}

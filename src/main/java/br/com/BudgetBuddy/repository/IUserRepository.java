package br.com.BudgetBuddy.repository;

import br.com.BudgetBuddy.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IUserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    boolean existsById(Long id);

    // Consulta que retorna usuários ordenados por id
    @Query("SELECT u FROM user u WHERE u.actived = true ORDER BY u.id")
    List<User> findByActivedAndOrderByUserId();


}

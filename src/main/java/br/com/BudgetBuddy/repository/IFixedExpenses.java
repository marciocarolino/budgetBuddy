package br.com.BudgetBuddy.repository;

import br.com.BudgetBuddy.domain.fixed_expenses.FixedExpenses;
import br.com.BudgetBuddy.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFixedExpenses extends JpaRepository<FixedExpenses, Long> {

}

package br.com.BudgetBuddy.repository;

import br.com.BudgetBuddy.domain.fixed_expenses.FixedExpenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFixedExpenses extends JpaRepository<FixedExpenses, Long> {
}

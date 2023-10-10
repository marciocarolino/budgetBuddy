package br.com.BudgetBuddy.repository;

import br.com.BudgetBuddy.domain.fixed_revenue.FixedRevenue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFixedRevenue extends JpaRepository<FixedRevenue, Long> {
}

package br.com.BudgetBuddy.domain.fixed_expenses;

import br.com.BudgetBuddy.domain.user.User;
import br.com.BudgetBuddy.dto.FixedExpensesDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "fixed_expenses")
@Table(name = "fixed_expenses", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FixedExpenses {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name="name_expenses")
    String name_expenses;

    @Column(name="description_expenses")
    String description_expenses;

    @Column(name="value")
    String value;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


    public FixedExpenses(FixedExpensesDTO fixedExpensesDTO) {
        this.name_expenses = fixedExpensesDTO.name_expeneses();
        this.description_expenses = fixedExpensesDTO.description_expenses();
        this.user = user;
    }
}

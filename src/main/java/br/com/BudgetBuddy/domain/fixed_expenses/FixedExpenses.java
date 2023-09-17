package br.com.BudgetBuddy.domain.fixed_expenses;

import br.com.BudgetBuddy.domain.user.User;
import br.com.BudgetBuddy.dto.FixedExpensesDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @Column(name = "house_or_apartment")
    private String house_or_apartment;

    @Column(name = "condominium_fee")
    private String condominium_fee;

    @Column(name = "iptu")
    private String iptu;

    @Column(name = "water_bill")
    private String water_bill;


    @Column(name = "electricity_bill")
    private String electricity_bill;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


    public FixedExpenses(FixedExpensesDTO fixedExpensesDTO) {
        this.electricity_bill = fixedExpensesDTO.electricity_bil();
        this.condominium_fee = fixedExpensesDTO.condominium_fee();
        this.iptu = fixedExpensesDTO.iptu();
        this.house_or_apartment = fixedExpensesDTO.house_or_apartment();
        this.water_bill = fixedExpensesDTO.water_bill();
        this.user = user;
    }
}

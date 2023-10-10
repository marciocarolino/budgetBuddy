package br.com.BudgetBuddy.domain.fixed_revenue;

import br.com.BudgetBuddy.domain.user.User;
import br.com.BudgetBuddy.dto.FixedRevenueDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "fixed_revenue")
@Table(name = "fixed_revenue", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FixedRevenue {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name="name_revenue")
    String name_revenue;

    @Column(name="description_revenue")
    String description_revenue;

    @Column(name="value")
    String value;

    @Column(name="create_at")
    Date create_at;

    @Column(name="updated_at")
    Date updated_at;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public FixedRevenue(FixedRevenueDTO fixedRevenueDTO){
        this.name_revenue = fixedRevenueDTO.name_revenue();
        this.description_revenue = fixedRevenueDTO.description_revenue();
        this.value = fixedRevenueDTO.value();
        this.user = user;
    }
}

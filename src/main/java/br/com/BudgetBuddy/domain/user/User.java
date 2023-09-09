package br.com.BudgetBuddy.domain.user;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "user")
@Table(name = "user", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "actived")
    private Boolean actived;

    @Column(name = "password")
    private String password;


    public User(RequestUser requestUser) {
        this.name = requestUser.name();
        this.email = requestUser.email();
        this.password = requestUser.password();
        this.actived = requestUser.actived();
    }
}

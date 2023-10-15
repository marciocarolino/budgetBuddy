package br.com.BudgetBuddy.domain.user;


import br.com.BudgetBuddy.dto.UserDTO;
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


    public User(UserDTO userDTO) {
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.actived = userDTO.actived();
    }
}

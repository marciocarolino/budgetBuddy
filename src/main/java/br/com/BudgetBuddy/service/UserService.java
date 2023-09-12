package br.com.BudgetBuddy.service;


import br.com.BudgetBuddy.domain.user.RequestUser;
import br.com.BudgetBuddy.domain.user.User;
import br.com.BudgetBuddy.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<List<User>> getAllUsers() {
        List<User> activeUsers = userRepository.findByActivedTrue();
        return ResponseEntity.ok(activeUsers);
    }

    public ResponseEntity createUser(@RequestBody @Valid RequestUser data) {
        if (userRepository.existsByEmail(data.email())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("E-mail já cadastrado!");
        }

        User user = new User(data);
        user.setActived(true);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity updateUser(@RequestBody @Valid RequestUser data) {
        Optional<User> optionalUser = userRepository.findById(data.id());


        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (!user.getEmail().equals(data.email())) {
                // Verifica se o novo email já existe em outro usuário
                if (userRepository.existsByEmail(data.email())) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("E-mail já cadastrado!");
                }
            }
            user.setName(data.name());
            user.setEmail(data.email());
            user.setPassword(data.password());
            user.setActived(data.actived());

            userRepository.save(user);


            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity deleteUser(int id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setActived(false);
            userRepository.save(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}

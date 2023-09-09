package br.com.BudgetBuddy.controllers;

import br.com.BudgetBuddy.domain.user.RequestUser;
import br.com.BudgetBuddy.domain.user.User;
import br.com.BudgetBuddy.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAll() {
        var allUsers = userRepository.findAll();
        return ResponseEntity.ok(allUsers).getBody();
    }

    @PostMapping()
    public ResponseEntity createUser(@RequestBody @Valid RequestUser data) {
        User user = new User(data);
        user.setActived(true);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping()
    public ResponseEntity updateUser(@RequestBody @Valid RequestUser data) {

        Optional<User> optionalUser = userRepository.findById(data.id());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(data.name());
            user.setEmail(data.email());
            user.setPassword(data.password());
            user.setActived(data.actived());
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {

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

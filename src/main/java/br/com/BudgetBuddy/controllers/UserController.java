package br.com.BudgetBuddy.controllers;

import br.com.BudgetBuddy.domain.user.RequestUser;
import br.com.BudgetBuddy.domain.user.User;
import br.com.BudgetBuddy.repository.UserRepository;
import br.com.BudgetBuddy.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAllActiveUsers() {
        return userService.getAllUsers();

    }

    @PostMapping()
    public ResponseEntity createUser(@RequestBody @Valid RequestUser data) {
        return userService.createUser(data);

    }

    @PutMapping()
    public ResponseEntity updateUser(@RequestBody @Valid RequestUser data) {
        return userService.updateUser(data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}

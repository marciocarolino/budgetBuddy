package br.com.BudgetBuddy.controllers.User;

import br.com.BudgetBuddy.domain.user.*;
import br.com.BudgetBuddy.dto.*;
import br.com.BudgetBuddy.service.user.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Tag(name = "Users", description = "CRUD USERS")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping()
    public ResponseEntity<List<User>> getAllActiveUsers() {
        return userService.getAllUsers();

    }

    @PostMapping("/register")
    public ResponseEntity createUser(@RequestBody @Valid UserDTO data) {
        return userService.createUser(data);

    }

    @PutMapping()
    public ResponseEntity updateUser(@RequestBody @Valid UserDTO data) {
        return userService.updateUser(data);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}

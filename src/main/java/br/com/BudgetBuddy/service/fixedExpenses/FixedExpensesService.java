package br.com.BudgetBuddy.service.fixedExpenses;

import br.com.BudgetBuddy.domain.fixed_expenses.FixedExpenses;
import br.com.BudgetBuddy.domain.user.User;
import br.com.BudgetBuddy.dto.FixedExpensesDTO;
import br.com.BudgetBuddy.repository.IFixedExpenses;
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
public class FixedExpensesService {


    @Autowired
    private IFixedExpenses fixedExpensesRepository;

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<List<FixedExpenses>> getAllFixedExpenses() {
        List<FixedExpenses> fixedExpenses = fixedExpensesRepository.findAll();
        return ResponseEntity.ok(fixedExpenses);
    }

    public ResponseEntity createFixedExpenses(@RequestBody @Valid FixedExpensesDTO data) {
        if (!userRepository.existsById(data.user_id())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Usuário não existe!");
        }

        Optional<User> findUser = userRepository.findById(Math.toIntExact(data.user_id()));

        if (findUser.isPresent()) {

            User user = findUser.get();

            FixedExpenses fixedExpenses = new FixedExpenses(data);
            fixedExpenses.setUser(user);


            fixedExpensesRepository.save(fixedExpenses);

            return ResponseEntity.ok(fixedExpenses);
        }else{
            return ResponseEntity.notFound().build();
        }
     }
    }

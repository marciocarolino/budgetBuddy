package br.com.BudgetBuddy.service.fixedExpenses;

import br.com.BudgetBuddy.domain.fixed_expenses.FixedExpenses;
import br.com.BudgetBuddy.domain.user.User;
import br.com.BudgetBuddy.dto.FixedExpensesDTO;
import br.com.BudgetBuddy.repository.IFixedExpenses;
import br.com.BudgetBuddy.repository.UserRepository;
import jakarta.validation.Valid;
import org.apache.velocity.exception.ResourceNotFoundException;
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
        try {
            // Verifica se o usuário existe
            User user = userRepository.findById(Math.toIntExact(data.user_id()))
                    .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

            // Verifica se o usuário está ativo
            if (!user.getActived()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Usuário Desativado!");
            }

            // Cria as despesas fixas associadas ao usuário
            FixedExpenses fixedExpenses = new FixedExpenses(data);
            fixedExpenses.setUser(user);

            fixedExpensesRepository.save(fixedExpenses);

            return ResponseEntity.ok(fixedExpenses);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("ID de usuário inválido");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}

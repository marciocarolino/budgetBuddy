package br.com.BudgetBuddy.service.fixedExpenses;

import br.com.BudgetBuddy.domain.fixed_expenses.FixedExpenses;
import br.com.BudgetBuddy.domain.user.User;
import br.com.BudgetBuddy.dto.FixedExpensesDTO;
import br.com.BudgetBuddy.repository.IFixedExpenses;
import br.com.BudgetBuddy.repository.IUserRepository;
import jakarta.validation.Valid;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FixedExpensesService {


    @Autowired
    private IFixedExpenses fixedExpensesRepository;

    @Autowired
    private IUserRepository IUserRepository;


    public ResponseEntity<List<FixedExpenses>> getAllFixedExpenses() {
        List<FixedExpenses> fixedExpenses = fixedExpensesRepository.findAll();
        return ResponseEntity.ok(fixedExpenses);
    }

    public ResponseEntity createFixedExpenses(@RequestBody @Valid FixedExpensesDTO fixedExpensesDTO) {
        try {
            // Verifica se o usuário existe
            User user = IUserRepository.findById(Math.toIntExact(fixedExpensesDTO.userId()))
                    .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));

            // Verifica se o usuário está ativo
            if (!user.getActived()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Usuário Desativado!");
            }

            if (fixedExpensesRepository.existsByUserId(Math.toIntExact(fixedExpensesDTO.userId()))) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Usuário já cadastrado!");
            }


            // Cria as despesas fixas associadas ao usuário
            FixedExpenses fixedExpenses = new FixedExpenses(fixedExpensesDTO);
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

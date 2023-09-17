package br.com.BudgetBuddy.controllers.FixedExpenses;

import br.com.BudgetBuddy.domain.fixed_expenses.FixedExpenses;
import br.com.BudgetBuddy.dto.FixedExpensesDTO;
import br.com.BudgetBuddy.service.fixedExpenses.FixedExpensesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fixedExpenses")
public class FixedExpensesController {


    @Autowired
    FixedExpensesService fixedExpensesService;


    @GetMapping
    public ResponseEntity<List<FixedExpenses>> getAllFixedExpense() {
        return fixedExpensesService.getAllFixedExpenses();
    }

    @PostMapping()
    public ResponseEntity createFixedExpenses(@RequestBody @Valid FixedExpensesDTO data) {
        return fixedExpensesService.createFixedExpenses(data);
    }

}

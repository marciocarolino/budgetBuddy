package br.com.BudgetBuddy.dto;


// DTO

public record FixedExpensesDTO(

        int id,
        String name_expeneses,
        String description_expenses,

        String value,
        Long user_id

) {
}

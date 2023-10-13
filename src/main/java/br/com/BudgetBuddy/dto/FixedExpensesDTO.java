package br.com.BudgetBuddy.dto;


// DTO

public record FixedExpensesDTO(

        int id,
        String nameExpeneses,
        String descriptionExpenses,

        String value,
        Long userId

) {
}

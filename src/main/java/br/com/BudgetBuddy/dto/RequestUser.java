package br.com.BudgetBuddy.dto;

public record RequestUser(

        int id,
        String name,
        String email,
        String password,
        Boolean actived
) {
}

package br.com.BudgetBuddy.domain.user;

public record RequestUser(

        int id,
        String name,
        String email,
        String password,
        Boolean actived
) {
}

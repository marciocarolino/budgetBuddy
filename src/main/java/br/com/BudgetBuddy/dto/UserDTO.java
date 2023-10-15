package br.com.BudgetBuddy.dto;

public record UserDTO(

        int id,
        String name,
        String email,
        String password,
        Boolean actived
) {
}

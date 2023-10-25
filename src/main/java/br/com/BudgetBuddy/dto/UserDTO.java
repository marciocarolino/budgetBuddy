package br.com.BudgetBuddy.dto;

import br.com.BudgetBuddy.domain.user.UserRole;

public record UserDTO(

        int id,
        String name,
        String email,
        String password,
        String login,
        UserRole role,
        Boolean actived
) {
}

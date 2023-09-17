package br.com.BudgetBuddy.dto;


// DTO

import br.com.BudgetBuddy.domain.user.User;

public record FixedExpensesDTO(

        int id,
        String house_or_apartment,
        String condominium_fee,
        String iptu,
        String water_bill,
        String electricity_bil,
        Long user_id

) {
}

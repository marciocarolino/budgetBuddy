package br.com.BudgetBuddy.dto;

public record FixedRevenueDTO(
        int id,
        String nameRevenue,
        String descriptionRevenue,
        String value,
        Long  userId

) {
}

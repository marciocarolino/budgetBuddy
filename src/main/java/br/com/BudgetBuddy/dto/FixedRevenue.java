package br.com.BudgetBuddy.dto;

public record FixedRevenue(
        int id,
        String name_revenue,
        String description_revenue,
        String value,
        Long  user_id

) {
}

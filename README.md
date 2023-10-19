# budgetBuddy
BudgetBuddy


classDiagram
    User ||--o{ Expenses : "One to Many"
    Expenses ||--o| User : "Many to One"
    User {
        + id (PK)
        name: String
        // Outros atributos do usuário aqui
    }
    Expenses {
        + id (PK)
        name_expenses: String
        description_expenses: String
        value: String
        user_id: FK (User)
    }


# budgetBuddy
BudgetBuddy



``` Fixed Expenses

erDiagram
    User ||--o{ Expenses : "One to Many"
    Expenses ||--o| User : "Many to One"
    Expenses {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        + id (PK)
        name_expenses
        description_expenses
        value
        user_id (FK)
    }
    User {
        + id (PK)
        // Outros atributos do usuário aqui
    }

```
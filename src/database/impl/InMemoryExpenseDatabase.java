package database.impl;

import database.ExpenseDatabase;
import models.Expense;

import java.util.ArrayList;
import java.util.Optional;

public class InMemoryExpenseDatabase implements ExpenseDatabase {

    private static ArrayList<Expense> REGISTERED_EXPNESES = new ArrayList<>();
    private static Integer lastSavedExpenseId = 0;

    @Override
    public Boolean addNewExpense(Expense expense) {

        lastSavedExpenseId = expense.getExpenseId();
        return REGISTERED_EXPNESES.add(expense);
    }
    @Override
    public ArrayList<Expense> getAllRegisteredExpense() {
        return new ArrayList<>(REGISTERED_EXPNESES);
    }

    @Override
    public Optional<Expense> getExpenseById(Integer id) {
        Expense expense = null;
        for (Expense e : REGISTERED_EXPNESES) {
            if (e.getExpenseId().equals(id)) {
                expense = e;
                break;
            }
        }
        return Optional.ofNullable(expense);
    }

    @Override
    public Integer getLastExpenseId() {
        return lastSavedExpenseId;
    }

}
package database.impl;

import database.ExpenseDatabase;
import models.Expense;
import models.User;

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

    public Optional<Expense> updateExpense(Integer expenseId, String description, Double cost, ArrayList<Integer> debterId, Integer payerId) {
        Optional<Expense> maybeExistingExpense = getExpenseById(expenseId);
        return maybeExistingExpense.map(expense -> updateExpense(expense, description, cost, debterId, payerId));
    }

    private Expense updateExpense(Expense existingExpense, String description, Double cost, ArrayList<Integer> debterId, Integer payerId) {
        int existingUserIndex = REGISTERED_EXPNESES.indexOf(existingExpense);
        existingExpense.setDiscription(description);
        existingExpense.setCost(cost);
        existingExpense.setDebterId(debterId);
        existingExpense.setPayerId(payerId);
        return existingExpense;
    }
}
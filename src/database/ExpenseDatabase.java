package database;

import models.Expense;

import java.util.ArrayList;
import java.util.Optional;

public interface ExpenseDatabase {

    Boolean addNewExpense(Expense expense);

    ArrayList<Expense> getAllRegisteredExpense();

    Optional<Expense> getExpenseById(Integer id);

    Optional<Expense> updateExpense(Integer expenseId, String description, Double cost, ArrayList<Integer> debterId, Integer payerId);

    Integer getLastExpenseId();

}

package services;

import models.Expense;
import models.User;

import java.util.ArrayList;
import java.util.Optional;

public interface ExpenseService {

    Integer createNewExpense(String description, Double cost, ArrayList<Integer> debterId, Integer payerId);

    ArrayList<Expense> getAllRegisteredExpenses();

    Optional<Expense> updateExpenseById(Integer expenseId, String description, Double cost, ArrayList<Integer> debterId, Integer payerId);

}

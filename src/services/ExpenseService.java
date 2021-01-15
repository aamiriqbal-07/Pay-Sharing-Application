package services;

import models.Expense;

import java.util.ArrayList;

public interface ExpenseService {

    Integer createNewExpense(String description, Double cost, ArrayList<Integer> debterId, Integer payerId);

    ArrayList<Expense> getAllRegisteredExpenses();

}

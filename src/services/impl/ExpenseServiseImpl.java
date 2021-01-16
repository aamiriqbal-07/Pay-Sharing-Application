package services.impl;

import database.ExpenseDatabase;
import database.impl.InMemoryExpenseDatabase;
import models.Expense;
import models.User;
import services.ExpenseService;
import util.ExpenseDataValidator;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.Optional;

public class ExpenseServiseImpl implements ExpenseService {

    private ExpenseDatabase expenseDatabase = new InMemoryExpenseDatabase();

    @Override
    public Integer createNewExpense(String description, Double cost, ArrayList<Integer> debterId, Integer payerId) {

        Boolean verifyDescription = ExpenseDataValidator.validateDescription(description);
        Boolean verifyCost = ExpenseDataValidator.validateCost(cost);
        Boolean verifyDebterId = ExpenseDataValidator.validateDebterId(debterId);
        Boolean verifypayerId = ExpenseDataValidator.validatePayerId(payerId);
//        System.out.println(verifyDescription +" "+ verifyCost +" "+ verifyDebterId +" "+ verifypayerId);
        if (verifyDescription && verifyCost && verifyDebterId && verifypayerId) {

            Integer lastExpenseId = expenseDatabase.getLastExpenseId();
            Integer generatedId = IdGenerator.getNextUserId(lastExpenseId);
            Expense expense = new Expense(generatedId, description, cost, debterId, payerId);
            Boolean newExpenseAdded = expenseDatabase.addNewExpense(expense);
            if(newExpenseAdded) {
                return expense.getExpenseId();
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Expense> getAllRegisteredExpenses() {
        return expenseDatabase.getAllRegisteredExpense();
    }

    @Override
    public Optional<Expense> updateExpenseById(Integer expenseId, String description, Double cost, ArrayList<Integer> debterId, Integer payerId) {
        return (expenseDatabase.updateExpense(expenseId, description, cost, debterId, payerId));
    }
}

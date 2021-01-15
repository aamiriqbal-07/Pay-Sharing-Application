package io;

import database.UserDatabase;
import database.impl.InMemoryUserDatabase;
import models.Expense;
import models.User;

import java.util.ArrayList;
import java.util.Optional;

public class DisplayExpenseOutput implements OutputCommand{

    private ArrayList<Expense> registerdExpenses;

    public DisplayExpenseOutput(ArrayList<Expense> registeredExpenses) {
        this.registerdExpenses = registeredExpenses;
    }

    @Override
    public String getMessage() {
        String message = "";
        UserDatabase userDatabase = new InMemoryUserDatabase();
        Optional<User> user;
        for(Expense expense : registerdExpenses) {
            message = message + expense.getExpenseId() + ". " + expense.getDiscription() + ", Cost - Rs. " +
                    expense.getCost() + ", shared between ";
            for(Integer debterId : expense.getDebterId()) {
                user = userDatabase.getUserById(debterId);
                message = message + user.get().getName() + ", ";
            }
            user = userDatabase.getUserById(expense.getPayerId());
            message = message + "Paid by " +user.get().getName();
        }
        return message;
    }
}

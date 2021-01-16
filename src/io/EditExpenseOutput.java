package io;

import database.UserDatabase;
import database.impl.InMemoryUserDatabase;
import models.Expense;
import models.User;

import java.util.Optional;

public class EditExpenseOutput implements OutputCommand{

    private Optional<Expense> expense;
    public EditExpenseOutput(Optional<Expense> expense) {
        this.expense = expense;
    }

    @Override
    public String getMessage() {

        String message = "";
        if(!(expense.isEmpty())) {

            UserDatabase userDatabase = new InMemoryUserDatabase();
            Optional<User> user;
            message = message + expense.get().getExpenseId() + ". " + expense.get().getDiscription() + ", Cost - Rs. " +
                    expense.get().getCost() + ", shared between ";
            for(Integer debterId : expense.get().getDebterId()) {
                user = userDatabase.getUserById(debterId);
                message = message + user.get().getName() + ", ";
            }
            user = userDatabase.getUserById(expense.get().getPayerId());
            message = message + "Paid by " +user.get().getName();

        } else
            message = "Not an Expense!";
        return message;
    }
}

package io;

import models.Expense;
import models.User;

import java.util.ArrayList;

public class DisplayExpenseInput implements InputCommand{

    private ArrayList<User> getRegisteredExpense;
    public DisplayExpenseInput(ArrayList<Expense> getRegisteredexpense) {
        this.getRegisteredExpense = getRegisteredExpense;
    }

    public ArrayList<User> getGetRegisteredUser() {
        return getRegisteredExpense;
    }
}

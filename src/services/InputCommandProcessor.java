package services;

import io.*;
import models.Expense;
import models.User;
import services.impl.ExpenseServiseImpl;
import services.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.Optional;

public class InputCommandProcessor {
    private UserService userService = new UserServiceImpl();
    private ExpenseService expenseService = new ExpenseServiseImpl();
//    private ExpenseService expenseService;
//    private DebtService debtService;
    public String processInputCommand(InputCommand inputCommand) {
        AddUserInput addUserInput;
        DisplayUserInput displayUserInput;
        EditUserInput editUserInput;
        AddExpenseInput addExpenseInput;
        DisplayExpenseInput displayExpenseInput;
        if (inputCommand instanceof AddUserInput) {

            addUserInput = (AddUserInput) inputCommand;
            Integer newUserId = userService.createNewUser(addUserInput.getName(), addUserInput.getPhoneNumber());

            AddUserOutput addUserOutput =  new AddUserOutput(newUserId);
            return addUserOutput.getMessage();

        } else if(inputCommand instanceof DisplayUserInput) {

            displayUserInput = (DisplayUserInput) inputCommand;
            ArrayList<User> registeredUsers = userService.getAllRegisteredUsers();

            DisplayUserOutput displayUserOutput = new DisplayUserOutput(registeredUsers);
            return displayUserOutput.getMessage();

        } else if(inputCommand instanceof EditUserInput) {

            editUserInput = (EditUserInput) inputCommand;
            Optional<User> user = userService.updateUserById(editUserInput.getId(),
                                        editUserInput.getName(), editUserInput.getPhoneNumber());
            EditUserOutput editUserOutput = new EditUserOutput(user);
            return editUserOutput.getMessage();
        } else if(inputCommand instanceof AddExpenseInput) {

            addExpenseInput = (AddExpenseInput) inputCommand;
            Integer newExpenseId = expenseService.createNewExpense(addExpenseInput.getDescription(),
                                    addExpenseInput.getCost(), addExpenseInput.getDebterId(), addExpenseInput.getPayerId());

            AddExpenseOutput addExpenseOutput =  new AddExpenseOutput(newExpenseId);
            return addExpenseOutput.getMessage();
        } else if(inputCommand instanceof DisplayExpenseInput) {
            displayExpenseInput = (DisplayExpenseInput) inputCommand;
            ArrayList<Expense> registeredExpenses = expenseService.getAllRegisteredExpenses();

            DisplayExpenseOutput displayExpenseOutput = new DisplayExpenseOutput(registeredExpenses);
            return displayExpenseOutput.getMessage();
        }

//        else
            return "Invalid Selection";
    }
}
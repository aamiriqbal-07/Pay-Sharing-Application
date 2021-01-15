package services;

import io.*;
import models.User;
import services.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.Optional;

public class InputCommandProcessor {
    private UserService userService = new UserServiceImpl();
//    private ExpenseService expenseService;
//    private DebtService debtService;
    public String processInputCommand(InputCommand inputCommand) {
        AddUserInput addUserInput;
        DisplayUserInput displayUserInput;
        EditUserInput editUserInput;
        if (inputCommand instanceof AddUserInput) {

            addUserInput = (AddUserInput) inputCommand;
            Integer newUserId = userService.createNewUser(addUserInput.getName(), addUserInput.getPhoneNumber());

            AddUserOutput addUserOutput =  new AddUserOutput(newUserId);
            return addUserOutput.getMessage();

        } else if(inputCommand instanceof DisplayUserInput) {

            displayUserInput = (DisplayUserInput) inputCommand;
            ArrayList<User> registeredUsers = userService.getAllRegisteredUsers();

            DiaplayUserOutput displayUserOutput = new DiaplayUserOutput(registeredUsers);
            return displayUserOutput.getMessage();

        } else if(inputCommand instanceof EditUserInput) {

            editUserInput = (EditUserInput) inputCommand;
            Optional<User> user = userService.updateUserById(editUserInput.getId(),
                                        editUserInput.getName(), editUserInput.getPhoneNumber());
            EditUserOutput editUserOutput = new EditUserOutput(user);
            return editUserOutput.getMessage();
        }

//        else
            return "Invalid Selection";
    }
}
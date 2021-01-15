package io;

import models.Expense;
import models.User;

import java.util.ArrayList;

public class InputParser {

    private static Object User;

    public static InputCommand parseInput(String inputString) {
        String[] inputCommandParts = inputString.split(",");
        String commandIdentifier = inputCommandParts[0];
        if (commandIdentifier.equals("ADD_USER") && inputCommandParts.length == 3)
            return new AddUserInput(inputCommandParts[1], inputCommandParts[2]);
        else if(commandIdentifier.equals("DISPLAY_USERS")) {
            return new DisplayUserInput(new ArrayList<User>());
        } else if(commandIdentifier.equals("EDIT_USER") && inputCommandParts.length == 4) {
            return new EditUserInput(Integer.parseInt(inputCommandParts[1]), inputCommandParts[2], inputCommandParts[3]);
        } else if(commandIdentifier.equals("ADD_EXPENSE") && inputCommandParts.length > 3) {

            String description = inputCommandParts[1];
            Double cost = Double.parseDouble(inputCommandParts[2]);
            Integer payerId = Integer.parseInt(inputCommandParts[inputCommandParts.length-1]);
            ArrayList<Integer> debterId = new ArrayList<>();
            for(Integer i=3; i<inputCommandParts.length-1; i++) {
                debterId.add(Integer.parseInt(inputCommandParts[i]));
            }
            return new AddExpenseInput(description, cost, debterId, payerId);
        } else if(commandIdentifier.equals("DISPLAY_EXPENSES")) {
            return new DisplayExpenseInput(new ArrayList<Expense>());

        }

        return null;
    }
}
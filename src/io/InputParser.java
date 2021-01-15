package io;

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
        }

        return null;
    }
}
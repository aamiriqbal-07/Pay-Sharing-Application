package io;

import models.User;

import java.util.ArrayList;

public class DisplayUserOutput implements OutputCommand {

    private ArrayList<User> registerdUsers;

    public DisplayUserOutput(ArrayList<User> registeredUsers) {
        this.registerdUsers = registeredUsers;
    }

    @Override
    public String getMessage() {
        String message = "";
        for(User user : registerdUsers) {
            message = message + user.getId() + " " + user.getName() + " " + user.getPhoneNumber() + "\n";
        }
        return message;
    }
}

package io;

import models.User;

import java.util.ArrayList;

public class DiaplayUserOutput implements OutputCommand {

    private ArrayList<User> registerdUsers;

    public DiaplayUserOutput(ArrayList<User> registeredUsers) {
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

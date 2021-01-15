package io;

import models.User;

import java.util.ArrayList;

public class DisplayUserInput implements InputCommand {

    private ArrayList<User> getRegisteredUser;
    public DisplayUserInput(ArrayList<User> getRegisteredUsers) {
        this.getRegisteredUser = getRegisteredUsers;
    }

    public ArrayList<User> getGetRegisteredUser() {
        return getRegisteredUser;
    }
}

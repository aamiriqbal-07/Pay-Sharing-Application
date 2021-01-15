package io;

import models.User;

import java.util.Optional;

public class EditUserOutput implements OutputCommand{

    private Optional<User> user;
    public EditUserOutput(Optional<User> user) {
        this.user = user;
    }

    @Override
    public String getMessage() {

        String message = "";
        if(!(user.isEmpty())) {
            message = message + user.get().getId() + " " + user.get().getName() + " " + user.get().getPhoneNumber();
        }
        else
            message = "Not a User!";
        return message;
    }
}

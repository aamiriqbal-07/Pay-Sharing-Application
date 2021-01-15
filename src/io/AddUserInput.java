package io;

public class AddUserInput implements InputCommand {
    private String name;
    private String phoneNumber;

    public AddUserInput(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

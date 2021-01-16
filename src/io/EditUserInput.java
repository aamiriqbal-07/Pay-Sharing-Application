package io;

public class EditUserInput implements InputCommand{

    private Integer id;
    private String name;
    private String phoneNumber;
    public EditUserInput(Integer Id, String name, String phoneNumber) {
        this.id = Id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getId() {
        return id;
    }
}

package io;


public class AddUserOutput implements OutputCommand{

    private Integer id;

    public AddUserOutput(Integer id) {
        this.id = id;
    }

    @Override
    public String getMessage() {

        String message;
        if(id != -1)
            message = "Yout User Id is " + id.toString();
        else
            message = "Error!";
        return message;
    }
}

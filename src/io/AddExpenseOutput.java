package io;


public class AddExpenseOutput implements OutputCommand{

    private Integer id;

    public AddExpenseOutput(Integer id) {
        this.id = id;
    }

    @Override
    public String getMessage() {

        String message;
        if(id != -1)
            message = "The Expense Id is " + id.toString();
        else
            message = "Error!";
        return message;
    }
}

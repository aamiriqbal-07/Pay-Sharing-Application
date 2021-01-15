package io;

import java.util.ArrayList;

public class AddExpenseInput implements InputCommand{

    private String description;
    private Double cost;
    private ArrayList<Integer> debterId;
    private Integer payerId;

    public AddExpenseInput(String description, Double cost, ArrayList<Integer> debterId, Integer payerId) {
        this.description = description;
        this.cost = cost;
        this.debterId = debterId;
        this.payerId = payerId;
    }

    public String getDescription() {
        return description;
    }

    public Double getCost() {
        return cost;
    }

    public ArrayList<Integer> getDebterId() {
        return debterId;
    }

    public Integer getPayerId() {
        return payerId;
    }
}

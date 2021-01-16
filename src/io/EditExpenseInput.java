package io;

import java.util.ArrayList;

public class EditExpenseInput implements InputCommand{

    private Integer expenseId;
    private String description;
    private Double cost;
    private ArrayList<Integer> debterId;
    private Integer payerId;

    public EditExpenseInput(Integer expenseId, String description, Double cost, ArrayList<Integer> debterId, Integer payerId) {
        this.expenseId = expenseId;
        this.description = description;
        this.cost = cost;
        this.debterId = debterId;
        this.payerId = payerId;
    }

    public Integer getExpenseId() {
        return expenseId;
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

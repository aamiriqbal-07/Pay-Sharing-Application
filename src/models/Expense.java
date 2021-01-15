package models;

import java.security.PrivateKey;
import java.util.ArrayList;

public class Expense {

    private Integer expenseId;
    private String discription;
    private Double cost;
    private ArrayList<Integer> debterId;
    private Integer payerId;

    public Expense(Integer expenseId, String discription, Double cost, ArrayList<Integer> debterId, Integer payerId) {
        this.expenseId = expenseId;
        this.discription = discription;
        this.cost = cost;
        this.debterId = debterId;
        this.payerId = payerId;
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public String getDiscription() {
        return discription;
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

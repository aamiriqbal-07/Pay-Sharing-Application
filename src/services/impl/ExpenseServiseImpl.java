//package services.impl;
//
//import database.ExpenseDatabase;
//import models.Expense;
//import models.User;
//import services.ExpenseService;
//import util.ExpenseDataValidator;
//
//import java.util.ArrayList;
//
//public class ExpenseServiseImpl implements ExpenseService {
//
//    private ExpenseDatabase expenseDatabase;
//
//    @Override
//    Integer createNewExpense(String description, Double Cost, ArrayList<Expense> debterId, Integer payerId) {
//
//        Boolean verifyDescription = ExpenseDataValidator.validateDescription(description);
//        Boolean verifyCost = ExpenseDataValidator.validateCost(description);
//        Boolean verifyDebterId = ExpenseDataValidator.validateDebterId(debterId);
//        Boolean verifypayerId = ExpenseDataValidator.validatePayerId(payerId);
//    }
//
//    @Override
//    public ArrayList<Expense> getAllRegisteredExpenses() {
//        return expenseDatabase.getAllRegisteredExpense();
//    }
//}

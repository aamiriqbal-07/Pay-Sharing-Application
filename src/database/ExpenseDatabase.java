package database;

import models.Expense;

import java.util.ArrayList;
import java.util.Optional;

public interface ExpenseDatabase {

    Boolean addNewExpense(Expense expense);

    ArrayList<Expense> getAllRegisteredExpense();

    Optional<Expense> getExpenseById(Integer id);

    Integer getLastExpenseId();

}

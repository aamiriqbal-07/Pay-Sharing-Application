package util;

import database.UserDatabase;
import database.impl.InMemoryUserDatabase;
import models.Expense;
import models.User;

import java.util.ArrayList;
import java.util.Optional;

public class ExpenseDataValidator {

    public static Boolean validateDescription(String description) {
        return (description.length()>0);
    }

    public static Boolean validateCost(Double cost) {
        return (cost>0);
    }

    public static Boolean validateDebterId(ArrayList<Integer> debterId) {

        UserDatabase userDatabase = new InMemoryUserDatabase();
        Integer totalDebter = 0;
        for(Integer id: debterId) {

            Optional<User> user = userDatabase.getUserById(id);
            if( !(user.isEmpty()) )
                totalDebter ++;
        }
        return ( totalDebter == debterId.size() );
    }

    public static Boolean validatePayerId(Integer payerId) {

        UserDatabase userDatabase = new InMemoryUserDatabase();
            Optional<User> user = userDatabase.getUserById(payerId);
            return ( !(user.isEmpty()) );
    }
}

package util;

import database.UserDatabase;
import models.User;

import java.util.Optional;

public class UserDataValidator {

    private UserDatabase userDatabase;

    public static Boolean validateName(String inputName) {
        return (inputName.length()>0);
    }

    public static Boolean validatePhoneNumber(String inputPhoneNumber) {
            if(inputPhoneNumber.length() == 10) {
                Integer count = 0;
                for(int i=0; i<inputPhoneNumber.length(); i++) {
                    if(inputPhoneNumber.charAt(i) >= '0' && inputPhoneNumber.charAt(i) <= '9')
                        count++;
                }
                return (count == 10);
            }
       return false;
    }
}

package services.impl;

import database.impl.InMemoryUserDatabase;
import models.User;
import database.UserDatabase;
import services.UserService;
import util.IdGenerator;
import util.UserDataValidator;

import java.util.ArrayList;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDatabase userDatabase = new InMemoryUserDatabase();

    @Override
    public Integer createNewUser(String inputName, String inputPhoneNumber) {
        if (UserDataValidator.validateName(inputName) && UserDataValidator.validatePhoneNumber(inputPhoneNumber)) {

            userDatabase = new InMemoryUserDatabase();
            Integer lastUserId = userDatabase.getLastUserId();
            Integer generatedId = IdGenerator.getNextUserId(lastUserId);
            User user = new User(generatedId, inputName, inputPhoneNumber);
            Boolean newUserAdded = userDatabase.addNewUser(user);
            if (newUserAdded) {
                return user.getId();
            }
        }
        return -1;
    }

    @Override
    public ArrayList<User> getAllRegisteredUsers() {
        return userDatabase.getAllRegisteredUsers();
    }

    @Override
    public Optional<User> updateUserById(Integer id, String name, String phoneNumber) {
        return (userDatabase.updateUser(id, name, phoneNumber));
    }
}
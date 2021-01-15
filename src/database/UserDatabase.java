package database;

import models.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserDatabase {
    Boolean addNewUser(User user);

    ArrayList<User> getAllRegisteredUsers();

    Optional<User> getUserById(Integer id);

    Optional<User> updateUser(Integer id, String name, String phoneNumber);

    Integer getLastUserId();
}
package database.impl;

import database.UserDatabase;
import models.User;

import java.util.ArrayList;
import java.util.Optional;

public class InMemoryUserDatabase implements UserDatabase {
    private static ArrayList<User> REGISTERED_USERS = new ArrayList<>();
    private static Integer lastSavedUserId = 0;

    @Override
    public Boolean addNewUser(User user) {
        lastSavedUserId = user.getId();
        return REGISTERED_USERS.add(user);
    }

    @Override
    public ArrayList<User> getAllRegisteredUsers() {
        return new ArrayList<>(REGISTERED_USERS);
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        User user = null;
        for (User u : REGISTERED_USERS) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> updateUser(Integer id, String name, String phoneNumber) {
        Optional<User> maybeExistingUser = getUserById(id);
        return maybeExistingUser.map(user -> updateUser(user, name, phoneNumber));
    }

    @Override
    public Integer getLastUserId() {
        return lastSavedUserId;
    }

    private User updateUser(User existingUser, String name, String phoneNumber) {
        int existingUserIndex = REGISTERED_USERS.indexOf(existingUser);
        existingUser.setName(name);
        existingUser.setPhoneNumber(phoneNumber);
//        REGISTERED_USERS.add(existingUserIndex, existingUser);
        return existingUser;
    }
}
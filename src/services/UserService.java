package services;

import models.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserService {

    public Integer createNewUser(String name, String phoneNumber);

    ArrayList<User> getAllRegisteredUsers();

    Optional<User> updateUserById(Integer id, String name, String phoneNumber);
}

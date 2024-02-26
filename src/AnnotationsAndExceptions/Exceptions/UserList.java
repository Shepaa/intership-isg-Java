package AnnotationsAndExceptions.Exceptions;

import java.util.ArrayList;

public class UserList {
    private final ArrayList<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) throws UserAlreadyExistsException {
        if (isUsernameExists(user.getUsername())) {
            throw new UserAlreadyExistsException("User with username " + user.getUsername() + " already exists.");
        }
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public boolean isUsernameExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User getUserByUsername(String username) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new UserNotFoundException("User with username " + username + " not found.");
    }
}

package AnnotationsAndExceptions.Exceptions;

public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();

        try {
            User user1 = new User("user1");
            userList.addUser(user1);
            userList.getUserByUsername("nonexistent_user");
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

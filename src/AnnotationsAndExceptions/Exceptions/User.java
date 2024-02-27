package AnnotationsAndExceptions.Exceptions;

public class User {
    private String username;
    private boolean blocked;

    public User(String username) {
        this.username = username;
        this.blocked = false;
    }

    public String getUsername() {
        return username;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}

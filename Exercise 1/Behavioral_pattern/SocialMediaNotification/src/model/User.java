package model;

import observer.Observer;
import util.LoggerUtil;

public class User implements Observer {
    private final String username;

    public User(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        this.username = username;
    }

    @Override
    public void update(Notification notification) {
        LoggerUtil.info("[" + username + "] received notification: " + notification.getMessage());
    }

    public String getUsername() {
        return username;
    }
}

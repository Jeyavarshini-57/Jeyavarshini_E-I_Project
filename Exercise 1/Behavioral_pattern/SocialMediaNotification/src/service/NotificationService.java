package service;

import model.User;
import observer.SocialMediaPlatform;
import util.LoggerUtil;

public class NotificationService {
    private final SocialMediaPlatform platform;

    public NotificationService(SocialMediaPlatform platform) {
        this.platform = platform;
    }

    public void addUser(User user) {
        platform.registerObserver(user);
        LoggerUtil.info("User [" + user.getUsername() + "] subscribed.");
    }

    public void removeUser(User user) {
        platform.removeObserver(user);
        LoggerUtil.info("User [" + user.getUsername() + "] unsubscribed.");
    }

    public void postNotification(String message) {
        platform.notifyObservers(message);
        LoggerUtil.info("Notification posted: " + message);
    }
}

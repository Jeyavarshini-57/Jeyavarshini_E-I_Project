package observer;

import model.Notification;
import util.LoggerUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SocialMediaPlatform implements Subject {
    private final List<Observer> observers;

    public SocialMediaPlatform() {
        observers = new CopyOnWriteArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        observers.add(observer);
        LoggerUtil.info("Observer registered.");
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        LoggerUtil.info("Observer removed.");
    }

    @Override
    public void notifyObservers(String message) {
        try {
            Notification notification = new Notification(message);
            for (Observer observer : observers) {
                observer.update(notification);
            }
        } catch (Exception e) {
            LoggerUtil.error("Failed to send notification: " + e.getMessage());
        }
    }
}

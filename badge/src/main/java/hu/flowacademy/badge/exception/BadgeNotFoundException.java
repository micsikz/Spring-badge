package hu.flowacademy.badge.exception;

public class BadgeNotFoundException extends RuntimeException {

    public BadgeNotFoundException (long id) {
        super("Could not found badge:" + id);
    }
}

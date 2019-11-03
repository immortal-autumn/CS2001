package common;

/**
 * This exception should be used to indicate that a card owner has not been registered.
 *
 */
public class OwnerNotRegisteredException extends Exception {
    public OwnerNotRegisteredException() {
        super("Owner has not registered!");
    }

    public OwnerNotRegisteredException(String MSG) {
        super(MSG);
    }

    public OwnerNotRegisteredException(String MSG, Throwable cause) {
        super(MSG, cause);
    }
}

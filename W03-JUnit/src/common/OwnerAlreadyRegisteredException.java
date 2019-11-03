package common;

/**
 * This exception should be used to indicate that a card owner has already been registered for use with a loyalty card.
 *
 */
public class OwnerAlreadyRegisteredException extends Exception {

    public OwnerAlreadyRegisteredException() {
        super("Owner has already registered!");
    }

    public OwnerAlreadyRegisteredException(String MSG) {
        super(MSG);
    }

    public OwnerAlreadyRegisteredException(String MSG, Throwable cause) {
        super(MSG, cause);
    }
}

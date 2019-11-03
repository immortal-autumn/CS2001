package common;

/**
 * This exception should be used to indicate that insufficient points are available.
 *
 */
public class InsufficientPointsException extends Exception {
    public InsufficientPointsException() {
        super("Points are not enough or unavailable!");
    }

    public InsufficientPointsException(String MSG) {
        super(MSG);
    }

    public InsufficientPointsException(String MSG, Throwable cause) {
        super(MSG, cause);
    }
}

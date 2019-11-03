package test;

import impl.LoyaltyCardOwner;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoyaltyCardOwnerTest {
    private final String email = "123@123.com";
    private final String name = "John";
    private LoyaltyCardOwner owner = new LoyaltyCardOwner(email, name);

    /**
     * This will test email have been successfully stored.
     */
    @Test
    public void getEmail() {
        assertEquals(email, owner.getEmail());
    }

    /**
     * This will test name have been successfully stored.
     */
    @Test
    public void getName() {
        assertEquals(name, owner.getName());
    }
}
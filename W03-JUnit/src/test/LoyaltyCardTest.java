package test;

import common.InsufficientPointsException;
import impl.LoyaltyCard;
import impl.LoyaltyCardOwner;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoyaltyCardTest {
    private LoyaltyCardOwner loyaltyCardOwner = new LoyaltyCardOwner("123@123.com", "John");
    private LoyaltyCard loyaltyCard = new LoyaltyCard(loyaltyCardOwner);

    /**
     * This test will test Owner have been successfully imported to loyalty card.
     */
    @Test
    public void getOwner() {
        assertEquals(loyaltyCard.getOwner(), loyaltyCardOwner);
    }

    /**
     * This test will test initial value of number of uses.
     */
    @Test
    public void getNumberOfUses() {
        assertEquals(0, loyaltyCard.getNumberOfUses());
    }

    /**
     * This test will test the function of get initial number of points.
     */
    @Test
    public void getNumberOfPoints() {
        assertEquals(0, loyaltyCard.getNumberOfUses());
    }

    /**
     * This test will test the function of add points.
     */
    @Test
    public void addPoints() {
        loyaltyCard.addPoints(12);
        assertEquals(12, loyaltyCard.getNumberOfPoints());
        assertEquals(1, loyaltyCard.getNumberOfUses());
    }

    /**
     * This will test use points method in loyalty card operator.
     * @throws InsufficientPointsException will throw when no enough points available
     */
    @Test
    public void usePoints() throws InsufficientPointsException {
        loyaltyCard.addPoints(12);
        loyaltyCard.usePoints(3);
        assertEquals(9, loyaltyCard.getNumberOfPoints());
        assertEquals(1, loyaltyCard.getNumberOfUses());
    }
}
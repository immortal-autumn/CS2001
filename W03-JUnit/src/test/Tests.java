package test;

import common.InsufficientPointsException;
import common.OwnerAlreadyRegisteredException;
import common.OwnerNotRegisteredException;
import org.junit.Test;

import common.AbstractFactoryClient;
import interfaces.*;

import static org.junit.Assert.*;

/**
 * This is a JUnit test class for the loyalty card ADT.
 *
 */
public class Tests extends AbstractFactoryClient {

    private final String email = "jon@jon.com";
    private final String name = "Jon";

    /**
     * This checks that the factory was able to call a sensible constructor to get a non-null instance of ILoyaltyCardOwner.
     */
    @Test
    public void loyaltyCardOwnerCreationNonNull() {
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);
//        System.out.println(loyaltyCardOwner.getEmail() + loyaltyCardOwner.getName());
        assertNotNull(loyaltyCardOwner);
//        return loyaltyCardOwner;
    }

    /**
     * This checks that the factory was able to call a sensible method to get a non-null instance of ILoyaltyCard.
     */
    @Test
    public void loyaltyCardCreationNonNull() {
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);
        ILoyaltyCard loyaltyCard = getFactory().makeLoyaltyCard(loyaltyCardOwner);
        assertNotNull(loyaltyCard);
    }

    /**
     * This checks that the factory create non-null information of owners' information.
     */
    @Test
    public void loyaltyCardOwnerInformationNonNull() {
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);
        assertNotNull(loyaltyCardOwner.getName());
        assertNotNull(loyaltyCardOwner.getEmail());
    }

    /**
     * This checks that the factory input users' information to make the non-null loyal card.
     */
    @Test
    public void loyaltyCardInformationNonNull() {
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);
        ILoyaltyCard loyaltyCard = getFactory().makeLoyaltyCard(loyaltyCardOwner);
        assertNotNull(loyaltyCard.getOwner());
    }

    /**
     * This checks that loyalCard information can be retrieved successfully.
     */
    @Test
    public void loyaltyCardInformationRetrieval() {
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);
        ILoyaltyCard loyaltyCard = getFactory().makeLoyaltyCard(loyaltyCardOwner);
        assertTrue(loyaltyCard.getOwner().getEmail().equals(email));
        assertTrue(loyaltyCard.getOwner().getName().equals(name));
    }

    /**
     * This Checks that the map does exist.
     */
    @Test
    public void mapDoesExistTest() {
        ILoyaltyCardOperator loyaltyCardOperator = getFactory().makeLoyaltyCardOperator();
        int numberOfCustomer = loyaltyCardOperator.getNumberOfCustomers();
        assertTrue(numberOfCustomer == 0);
    }

    /**
     * This checks that the information has successfully stored in map.
     */
    @Test
    public void loyaltyCardInformationStoreInMap() {
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);
        ILoyaltyCardOperator loyaltyCardOperator = getFactory().makeLoyaltyCardOperator();
        try {
            loyaltyCardOperator.registerOwner(loyaltyCardOwner);
            String a = Integer.toString(loyaltyCardOperator.getNumberOfCustomers());
            assertTrue(a, loyaltyCardOperator.getNumberOfCustomers() == 1);
        }
        catch (OwnerAlreadyRegisteredException e) {
            e.printStackTrace();
        }
    }

    /**
     * This checks that information can be retrieved from operator.
     */
    @Test
    public void loyaltyCardInformationInMapRetrieval() {
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);
        ILoyaltyCardOwner loyaltyCardOwner2 =
                getFactory().makeLoyaltyCardOwner("hl74@st-andrews.ac.uk", "Elwin");
        ILoyaltyCardOperator loyaltyCardOperator = getFactory().makeLoyaltyCardOperator();
        try {
            loyaltyCardOperator.registerOwner(loyaltyCardOwner);
            loyaltyCardOperator.registerOwner(loyaltyCardOwner2);
            assertEquals(2, loyaltyCardOperator.getNumberOfCustomers());
            assertEquals(0, loyaltyCardOperator.getNumberOfUses(email));
            assertEquals(0, loyaltyCardOperator.getNumberOfPoints(email));
        }
        catch (OwnerAlreadyRegisteredException | OwnerNotRegisteredException e) {
            e.printStackTrace();
        }
    }

    /**
     * This checks that functions can be used and Insufficient points Exception will be thrown.
     */
    @Test
    public void loyalCardOperatorTest() throws OwnerNotRegisteredException, OwnerAlreadyRegisteredException {
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);
        ILoyaltyCardOwner loyaltyCardOwner2 =
                getFactory().makeLoyaltyCardOwner("123@123.com", "Elwin");
        ILoyaltyCardOperator loyaltyCardOperator = getFactory().makeLoyaltyCardOperator();
        loyaltyCardOperator.registerOwner(loyaltyCardOwner);
        loyaltyCardOperator.registerOwner(loyaltyCardOwner2);
        try {
            assertEquals(2, loyaltyCardOperator.getNumberOfCustomers());

            loyaltyCardOperator.unregisterOwner(loyaltyCardOwner);
            assertEquals(1, loyaltyCardOperator.getNumberOfCustomers());
        }
        catch (OwnerNotRegisteredException e) {
            System.err.println(e.getMessage());
        }

        try {
            assertFalse(200 == loyaltyCardOperator.getNumberOfPoints("123@123.com"));
            loyaltyCardOperator.processPointsPurchase("123@123.com", 200);
        }
        catch (InsufficientPointsException e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * This Checks that points can be used and being added.
     */
    @Test
    public void loyaltyCardOperatorPointsTest() {
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);
        ILoyaltyCardOperator loyaltyCardOperator = getFactory().makeLoyaltyCardOperator();
        try {
            loyaltyCardOperator.registerOwner(loyaltyCardOwner);
            loyaltyCardOperator.processMoneyPurchase(email, 200);
            assertEquals(2, loyaltyCardOperator.getTotalNumberOfPoints());
            assertEquals(2, loyaltyCardOperator.getNumberOfPoints(email));
            assertEquals(1, loyaltyCardOperator.getNumberOfUses(email));
        }
        catch (OwnerAlreadyRegisteredException | OwnerNotRegisteredException e) {
            e.printStackTrace();
        }
    }

    /**
     * This tests a re-registered owner.
     */
    @Test
    public void ownerAlreadyRegisteredTest() {
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);
        ILoyaltyCardOperator loyaltyCardOperator = getFactory().makeLoyaltyCardOperator();
        try {
            loyaltyCardOperator.registerOwner(loyaltyCardOwner);
            loyaltyCardOperator.registerOwner(loyaltyCardOwner);
        }
        catch (OwnerAlreadyRegisteredException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
    * This tests owner not registered exception happens when unregister an unavailable user..
    */
    @Test
    public void ownerNotRegisteredTest() {
        ILoyaltyCardOperator loyaltyCardOperator = getFactory().makeLoyaltyCardOperator();
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);
        try {
            loyaltyCardOperator.unregisterOwner(loyaltyCardOwner);
        }
        catch (OwnerNotRegisteredException e) {
            System.err.println(e.getMessage());
        }
        assertFalse(loyaltyCardOperator.getNumberOfCustomers() == 1);
    }

    /**
     * This will test users will get correct uses when processing points purchase.
     */
    @Test
    public void pointsPurchaseTest() throws OwnerAlreadyRegisteredException, InsufficientPointsException, OwnerNotRegisteredException {
        ILoyaltyCardOperator loyaltyCardOperator = getFactory().makeLoyaltyCardOperator();
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);
        loyaltyCardOperator.registerOwner(loyaltyCardOwner);
        try {
            loyaltyCardOperator.processMoneyPurchase(email, 200);
        }
        catch (OwnerNotRegisteredException e) {
            System.err.println(e.getMessage());
        }
        assertEquals(2, loyaltyCardOperator.getNumberOfPoints(email));
        loyaltyCardOperator.processPointsPurchase(email, 2);
        assertEquals(0, loyaltyCardOperator.getNumberOfPoints(email));
        assertEquals(2, loyaltyCardOperator.getNumberOfUses(email));
    }

    /**
     * This will test the error conditions happens when no enough points available.
     */
    @Test
    public void processMoneyPurchaseException() {
        ILoyaltyCardOperator loyaltyCardOperator = getFactory().makeLoyaltyCardOperator();
        ILoyaltyCardOwner loyaltyCardOwner = getFactory().makeLoyaltyCardOwner(email, name);

        try {
            loyaltyCardOperator.processMoneyPurchase(loyaltyCardOwner.getEmail(), 200);
        }
        catch (OwnerNotRegisteredException e) {
            System.err.println(e.getMessage());
        }
        assertEquals(loyaltyCardOperator.getNumberOfCustomers(), 0);
    }

    /**
     * This will test when no registered users appeared and no most used users here.
     */
    @Test
    public void noUserGetMostUsedTest() {
        ILoyaltyCardOperator loyaltyCardOperator = getFactory().makeLoyaltyCardOperator();
        try {
            loyaltyCardOperator.getMostUsed();
        }
        catch (OwnerNotRegisteredException e) {
            System.err.println(e.getMessage());
        }
        assertEquals(loyaltyCardOperator.getNumberOfCustomers(), 0);
    }


}
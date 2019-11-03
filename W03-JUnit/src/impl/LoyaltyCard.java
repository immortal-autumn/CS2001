package impl;

import common.InsufficientPointsException;
import interfaces.ILoyaltyCard;
import interfaces.ILoyaltyCardOwner;

/**
 * This class represents a Loyalty Card, recording information relating to an owners use of the card.
 *
 */
public class LoyaltyCard implements ILoyaltyCard {

    private ILoyaltyCardOwner loyaltyCardOwner;
    private int numberOfUses = 0;
    private int numberOfPoints = 0;

    /**
     * This gives value to loyal card owner.
     * @param loyaltyCardOwner is the value of loyaltyCardOwner
     */
    public LoyaltyCard(ILoyaltyCardOwner loyaltyCardOwner) {
        this.loyaltyCardOwner = loyaltyCardOwner;
    }

    @Override
    public ILoyaltyCardOwner getOwner() {
        // TODO Auto-generated method stub
        return loyaltyCardOwner;
    }

    @Override
    public int getNumberOfUses() {
        // TODO Auto-generated method stub
        return numberOfUses;
    }

    @Override
    public int getNumberOfPoints() {
        // TODO Auto-generated method stub
        return numberOfPoints;
    }

    @Override
    public void addPoints(int points) {
        // TODO Auto-generated method stub
        numberOfPoints += points;
        numberOfUses += 1;
    }

    @Override
    public void usePoints(int points) throws InsufficientPointsException {
        // TODO Auto-generated method stub
        numberOfPoints = numberOfPoints - points;
//        numberOfUses += 1;
    }

}

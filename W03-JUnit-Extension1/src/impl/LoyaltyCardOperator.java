package impl;

import common.AbstractFactoryClient;
import common.InsufficientPointsException;
import common.OwnerAlreadyRegisteredException;
import common.OwnerNotRegisteredException;
import interfaces.ILoyaltyCard;
import interfaces.ILoyaltyCardOperator;
import interfaces.ILoyaltyCardOwner;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a simple loyalty card operator.
 *
 */
public class LoyaltyCardOperator extends AbstractFactoryClient implements ILoyaltyCardOperator {

    private Map<String, ILoyaltyCard> registeredCard = new HashMap();

    @Override
    public void registerOwner(ILoyaltyCardOwner loyaltyCardOwner) throws OwnerAlreadyRegisteredException {
        // TODO Auto-generated method stub
        if (!registeredCard.containsKey(loyaltyCardOwner.getEmail())){
            ILoyaltyCard loyaltyCard = new LoyaltyCard(loyaltyCardOwner);
            registeredCard.put(loyaltyCardOwner.getEmail(), loyaltyCard);
        }
        else {
            throw new OwnerAlreadyRegisteredException("Owner has already registered!");
        }
    }

    @Override
    public void unregisterOwner(ILoyaltyCardOwner loyaltyCardOwner) throws OwnerNotRegisteredException {
        // TODO Auto-generated method stub
        if (registeredCard.containsKey(loyaltyCardOwner.getEmail())){
            registeredCard.remove(loyaltyCardOwner.getEmail());
        }
        else {
            throw new OwnerNotRegisteredException();
        }
    }

    @Override
    public void processMoneyPurchase(String ownerEmail, int pence) throws OwnerNotRegisteredException {
        // TODO Auto-generated method stub
        if(registeredCard.get(ownerEmail) != null){
            registeredCard.get(ownerEmail).addPoints(pence / 100);
        }
        else {
            throw new OwnerNotRegisteredException();
        }
    }

    @Override
    public void processPointsPurchase(String ownerEmail, int pence)
            throws InsufficientPointsException, OwnerNotRegisteredException {
        // TODO Auto-generated method stub
        if (registeredCard.get(ownerEmail) != null) {
            int current_point = registeredCard.get(ownerEmail).getNumberOfPoints();
            if (current_point <= pence) {
                registeredCard.get(ownerEmail).usePoints(current_point);
                pence -= current_point;
                registeredCard.get(ownerEmail).addPoints(pence / 100);
            }
            else {
                registeredCard.get(ownerEmail).usePoints(pence);
                registeredCard.get(ownerEmail).addPoints(0);
            }
        }
        else throw new OwnerNotRegisteredException();
    }

    @Override
    public int getNumberOfCustomers() {
        // TODO Auto-generated method stub
        return registeredCard.size();
    }

    @Override
    public int getTotalNumberOfPoints() {
        // TODO Auto-generated method stub
        int totalPoints = 0;
        for (ILoyaltyCard values : registeredCard.values()) {
            totalPoints += values.getNumberOfPoints();
        }
        return totalPoints;
    }

    @Override
    public int getNumberOfPoints(String ownerEmail) throws OwnerNotRegisteredException {
        // TODO Auto-generated method stub
        if (registeredCard.get(ownerEmail) != null) {
            return registeredCard.get(ownerEmail).getNumberOfPoints();
        }
        else throw new OwnerNotRegisteredException();
    }

    @Override
    public int getNumberOfUses(String ownerEmail) throws OwnerNotRegisteredException {
        // TODO Auto-generated method stub
        if (registeredCard.get(ownerEmail) != null) {
            return registeredCard.get(ownerEmail).getNumberOfUses();
        }
        else throw new OwnerNotRegisteredException();
    }

    @Override
    public void addCertainPoints(String ownerEmail, int points) throws OwnerNotRegisteredException {
        if (registeredCard.get(ownerEmail) != null) {
            registeredCard.get(ownerEmail).addPoints(points);
        }
        else throw new OwnerNotRegisteredException();
    }

    @Override
    public void pointsTransaction(String ownerEmail, String receiverEmail, int transcation_points)
            throws OwnerNotRegisteredException, InsufficientPointsException {
        if (registeredCard.get(ownerEmail) != null) {
            if (registeredCard.get(receiverEmail) != null) {
                if (transcation_points <= registeredCard.get(ownerEmail).getNumberOfPoints()) {
                    registeredCard.get(ownerEmail).usePoints(transcation_points);
                    registeredCard.get(receiverEmail).addPoints(transcation_points);
                }
                else throw new InsufficientPointsException("Your points is not enough! Current points in account: " +
                        ownerEmail + " are " + registeredCard.get(ownerEmail).getNumberOfPoints());
            }
            else throw new OwnerNotRegisteredException(ownerEmail + " is not registered!");
        }
        else throw new OwnerNotRegisteredException(ownerEmail + " is not registered!");
    }

    @Override
    public ILoyaltyCardOwner getMostUsed() throws OwnerNotRegisteredException {
        // TODO Auto-generated method stub
        ILoyaltyCard mostUsedLoyaltyCard = null;
        int max = 0;
        for (ILoyaltyCard card : registeredCard.values()) {
            int used = card.getNumberOfUses();
            max = Math.max(max, used);
            if (max == used) mostUsedLoyaltyCard = card;
        }
        if (mostUsedLoyaltyCard != null){
            return mostUsedLoyaltyCard.getOwner();
        }
        else throw new OwnerNotRegisteredException();
    }

}

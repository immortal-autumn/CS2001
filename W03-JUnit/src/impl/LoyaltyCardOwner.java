package impl;

import interfaces.ILoyaltyCardOwner;

/**
 * This class represents loyalty card owners.
 *
 */
public class LoyaltyCardOwner implements ILoyaltyCardOwner {

    private String email;
    private String name;

    /**
     * This constructor gives value of email and names so that it can be get.
     * @param email is user's email
     * @param name is user's name
     */
    public LoyaltyCardOwner(String email, String name) {
        this.email = email;
        this.name = name;
    }

    @Override
    public String getEmail() {
        // TODO Auto-generated method stub
        return email;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

}

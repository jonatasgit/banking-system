package banking;

import java.util.ArrayList;
import java.util.List;

/**
 * Account implementation for commercial (business) customers.
 * The account's holder is a {@link Company}.
 */
public class CommercialAccount extends Account {
    private List<Person> authorizedUsers;
    private Company company;
    //public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {

    //}

    protected CommercialAccount(Company company, AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
        super(accountHolder, accountNumber, pin, startingDeposit);
        this.company = company;
        this.authorizedUsers = new ArrayList<>();
    }

    /**
     * Add person to list of authorized users.
     *
     * @param person The authorized user to be added to the account.
     */
    protected void addAuthorizedUser(Person person) {
       this.authorizedUsers.add(person);
    }

    /**
     * Verify if the person is part of the list of authorized users for this account.
     *
     * @param person
     * @return <code>true</code> if person matches an authorized user in {@link #authorizedUsers}; <code>false</code> otherwise.
     */
    public boolean isAuthorizedUser(Person person) {
        if(person == null)
            return false;
        for(Person p : this.authorizedUsers){
            if(p.equals(person))
                return true;
        }
        return false;
    }
}

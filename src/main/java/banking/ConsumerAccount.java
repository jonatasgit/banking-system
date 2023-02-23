package banking;

/**
 * Account implementation for consumer (domestic) customers.
 * The account's holder is a {@link Person}.
 */
public class ConsumerAccount extends Account{

    private Person person;

    protected ConsumerAccount(Person person, AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
        super(accountHolder, accountNumber, pin, startingDeposit);
        this.person = person;
    }
    //public ConsumerAccount(Person person, Long accountNumber, int pin, double currentBalance) {

    //}
}

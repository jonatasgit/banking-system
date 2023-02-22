package banking;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * The Bank implementation.
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
        accounts = new LinkedHashMap<>();
    }
    public Bank(LinkedHashMap<Long, Account> accounts) {
        this.accounts = accounts;
    }

    private Account getAccount(Long accountNumber) {
        return this.accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        Long accNumber = new Random().nextLong();
        CommercialAccount acc = new CommercialAccount(company, null, accNumber, pin, startingDeposit);
        accounts.put(accNumber, acc);

        return accNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {

        return -1L;
    }

    public double getBalance(Long accountNumber) {
        return this.accounts.get(accountNumber).getBalance();
    }

    public void credit(Long accountNumber, double amount) {
        // TODO: complete the method
    }

    public boolean debit(Long accountNumber, double amount) {
        // TODO: complete the method
        return false;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        // TODO: complete the method
        return false;
    }
    
    public void addAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        CommercialAccount acc = (CommercialAccount) getAccount(accountNumber);
        acc.addAuthorizedUser(authorizedPerson);
    }

    public boolean checkAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        CommercialAccount acc = (CommercialAccount) getAccount(accountNumber);
        if(acc == null)
            return false;
        return acc.isAuthorizedUser(authorizedPerson);
    }

    public Map<String, Double> getAverageBalanceReport() {
        // TODO: complete the method
        return new HashMap<>();
    }
}

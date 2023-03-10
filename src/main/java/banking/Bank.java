package banking;

import java.util.*;

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
        Long accNumber = null;
        Account lastAcc = getLast(accounts);

        if(Objects.isNull(lastAcc)){
            accNumber = new Random().nextLong();
        } else {
            accNumber = lastAcc.getAccountNumber()+1;
        }

        CommercialAccount acc = new CommercialAccount(company, null, accNumber, pin, startingDeposit);
        accounts.put(accNumber, acc);

        return accNumber;
    }



    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        Long accNumber = null;
        Account lastAcc = getLast(accounts);

        if(Objects.isNull(lastAcc)){
            accNumber = new Random().nextLong();
        } else {
            accNumber = lastAcc.getAccountNumber()+1;
        }

        ConsumerAccount acc = new ConsumerAccount(person, null, accNumber, pin, startingDeposit);
        accounts.put(accNumber, acc);

        return accNumber;
    }

    private static Account getLast(LinkedHashMap<Long, Account> lhm)
    {
        int count = 1;

        for (Map.Entry<Long, Account> it : lhm.entrySet()) {
            if (count == lhm.size()) {
                return it.getValue();
            }
            count++;
        }

        return null;
    }
    public double getBalance(Long accountNumber) {
        if(Objects.nonNull(this.accounts.get(accountNumber))){
            return this.accounts.get(accountNumber).getBalance();
        } else {
            return -1L;
        }
    }

    public void credit(Long accountNumber, double amount) {
        if(Objects.nonNull(this.accounts.get(accountNumber))){
            Account acc = this.accounts.get(accountNumber);
            acc.creditAccount(amount);
        }
    }

    public boolean debit(Long accountNumber, double amount) {
        if(Objects.nonNull(this.accounts.get(accountNumber))){
            Account acc = this.accounts.get(accountNumber);
            return acc.debitAccount(amount);
        }
        return false;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        if(Objects.nonNull(this.accounts.get(accountNumber))){
            Account acc = this.accounts.get(accountNumber);
            return acc.validatePin(pin);
        } else {
            return false;
        }
    }
    
    public void addAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        CommercialAccount acc = (CommercialAccount) getAccount(accountNumber);
        acc.addAuthorizedUser(authorizedPerson);
    }

    public boolean checkAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        if(getAccount(accountNumber) instanceof CommercialAccount){
            CommercialAccount acc = (CommercialAccount) getAccount(accountNumber);
            return acc.isAuthorizedUser(authorizedPerson);
        } else {
            return false;
        }
    }

    public Map<String, Double> getAverageBalanceReport() {
        HashMap<String, Double>  avarageBalance = new HashMap<>();
        Set<Long> keys = this.accounts.keySet();
        int consumerCount = 0;
        Double consumerTotal = (double) 0;
        int comercialCount = 0;
        Double comercialTotal = (double) 0;
        for(Long key : keys){
            Account acc = this.accounts.get(key);
            if(acc instanceof CommercialAccount){
                comercialCount++;
                comercialTotal = comercialTotal + acc.getBalance();
            } else {
                consumerCount++;
                consumerTotal = consumerTotal + acc.getBalance();
            }
            avarageBalance.put("ConsumerAccount", consumerTotal/consumerCount);
            avarageBalance.put("CommercialAccount", comercialTotal/comercialCount);
        }
        return avarageBalance;
    }
}

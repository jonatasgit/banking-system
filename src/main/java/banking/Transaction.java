package banking;

/**
 * A bank transaction implementation.
 */
public class Transaction implements TransactionInterface {
    private Long accountNumber;
    private BankInterface bank;

    /**
     * @param bank          The bank where the account is housed.
     * @param accountNumber The customer's account number.
     * @param attemptedPin  The PIN entered by the customer.
     * @throws Exception Account validation failed.
     */
    public Transaction(BankInterface bank, Long accountNumber, int attemptedPin) throws Exception {
        this.accountNumber = accountNumber;
        this.bank = bank;
    }

    public double getBalance() {
        return this.bank.getBalance(this.accountNumber);
    }

    public void credit(double amount) {
        this.bank.credit(this.accountNumber, amount);
    }

    public boolean debit(double amount) {
        // TODO: complete the method
        return false;
    }
}

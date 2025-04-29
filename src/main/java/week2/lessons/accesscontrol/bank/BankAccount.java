package main2.week2.lessons.accesscontrol.bank;

/**
 * BankAccount class represents a customer's bank account with basic operations.
 * 
 * This class demonstrates different access modifiers:
 * - Private fields (number, balance) for encapsulation
 * - Protected method (deposit) accessible only within the package and
 * subclasses
 * - Public methods (withdraw, transfer, getBalance) accessible from anywhere
 */
public class BankAccount {
    /** The account number (private for security) */
    private int number;

    /** The current balance (private to prevent unauthorized modifications) */
    private double balance;

    /**
     * Creates a new bank account with the specified number and initial balance.
     * 
     * @param number  The account number
     * @param balance The initial account balance
     */
    public BankAccount(int number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    /**
     * Deposits money into the account.
     * This method is protected to restrict access to the package and subclasses.
     * 
     * @param amount The amount to deposit
     * @return true if the deposit was successful, false otherwise
     */
    protected boolean deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            return true;
        }
        return false;
    }

    /**
     * Withdraws money from the account.
     * This method is public to allow access from anywhere, including ATMs.
     * 
     * @param amount The amount to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    /**
     * Transfers money from this account to another account.
     * Limited to 50% of the current balance for security.
     * 
     * @param depositToAccount The account to transfer money to
     * @param amount           The amount to transfer
     * @return true if the transfer was successful, false otherwise
     */
    public boolean transfer(BankAccount depositToAccount, double amount) {
        if (amount <= this.balance / 2) {
            this.withdraw(amount);
            depositToAccount.deposit(amount);
            return true;
        }
        return false;
    }

    /**
     * Gets the current account balance.
     * 
     * @return The current balance
     */
    public double getBalance() {
        return balance;
    }
}

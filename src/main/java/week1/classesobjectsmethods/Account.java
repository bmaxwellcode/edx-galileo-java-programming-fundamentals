package week1.classesobjectsmethods;

/**
 * Represents a bank account with basic banking operations.
 * Demonstrates object creation, instance variables, and methods.
 */
public class Account {

    /** Static counter to generate unique account numbers. */
    public static int nextAccount = 1;

    /** Account holder's name. */
    private String name;

    /** Unique account identifier. */
    private int accountNumber;

    /** Current balance in the account. */
    private int balance;

    /**
     * Creates a new account with the given name and zero balance.
     *
     * @param n The account holder's name
     */
    public Account(String n) {
        name = new String(n);
        accountNumber = nextAccount;
        balance = 0;
        nextAccount++;
    }

    /**
     * Creates a new account with the given name and initial balance.
     *
     * @param n The account holder's name
     * @param b The initial balance
     */
    public Account(String n, int b) {
        name = new String(n);
        accountNumber = nextAccount;
        balance = b;
        nextAccount++;
    }

    /**
     * Adds funds to the account.
     *
     * @param b The amount to deposit
     */
    public void deposit(int b) {
        balance = balance + b;
    }

    /**
     * Withdraws funds from the account if sufficient balance exists.
     * Demonstrates conditional logic with if-else control flow.
     *
     * @param b The amount to withdraw
     */
    public void withdraw(int b) {
        if (b <= balance) {
            balance -= b;
            return;
        }
        System.out.println("Insufficient funds");
    }

    /**
     * Returns a string representation of the account details.
     *
     * @return Account information as a formatted string
     */
    public String toString() {
        return "\nname: " + name + "\naccount number: " + accountNumber
                + "\nbalance: " + balance;
    }
}
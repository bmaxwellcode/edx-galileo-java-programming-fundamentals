package main2.week2.lessons.accesscontrol.atm;

import main2.week2.lessons.accesscontrol.bank.BankAccount;

/**
 * ATM class represents an automated teller machine that can perform limited
 * banking operations.
 * 
 * This class demonstrates access control across different packages:
 * - It's in a different package than BankAccount
 * - It can access public methods of BankAccount (withdraw, getBalance)
 * - It cannot access protected or package-private methods of BankAccount
 * (deposit)
 */
public class ATM {
    /** The unique identifier for this ATM */
    private int id;

    /**
     * Creates a new ATM with the specified ID.
     * 
     * @param id The unique identifier for this ATM
     */
    public ATM(int id) {
        this.id = id;
    }

    /**
     * Withdraws money from a bank account through this ATM.
     * This method can only access the public methods of BankAccount
     * since ATM is in a different package.
     * 
     * @param account The account to withdraw from
     * @param amount  The amount to withdraw
     */
    public void withdraw(BankAccount account, double amount) {
        boolean result = account.withdraw(amount);
        if (result) {
            System.out.println("Successful withdraw on ATM of $" + amount);
        } else {
            System.out.println("Insufficient funds to withdraw from ATM!");
        }
    }
}

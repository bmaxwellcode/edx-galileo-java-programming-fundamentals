package main2.week2.lessons.accesscontrol.bank;

/**
 * BankTeller class represents a bank employee who can perform operations on
 * accounts.
 * 
 * This class demonstrates how a class within the same package as BankAccount
 * can access its protected methods (like deposit), showing package-level access
 * control.
 */
public class BankTeller {
    /**
     * Deposits money into a bank account.
     * Bank tellers can access the protected deposit method since they're in the
     * same package.
     * 
     * @param account The account to deposit into
     * @param amount  The amount to deposit
     */
    public void deposit(BankAccount account, double amount) {
        boolean result = account.deposit(amount);
        if (result) {
            System.out.println("Successful deposit of $" + amount);
        } else {
            System.out.println("Error on deposit");
        }
    }

    /**
     * Withdraws money from a bank account.
     * 
     * @param account The account to withdraw from
     * @param amount  The amount to withdraw
     */
    public void withdraw(BankAccount account, double amount) {
        boolean result = account.withdraw(amount);
        if (result) {
            System.out.println("Successful withdrawal of $" + amount);
        } else {
            System.out.println("Insufficient funds for withdrawal");
        }
    }

    /**
     * Transfers money between two bank accounts.
     * 
     * @param withdrawFromAccount The account to transfer money from
     * @param depositToAccount    The account to transfer money to
     * @param amount              The amount to transfer
     */
    public void transfer(BankAccount withdrawFromAccount, BankAccount depositToAccount, double amount) {
        boolean result = withdrawFromAccount.transfer(depositToAccount, amount);
        if (result) {
            System.out.println("Successful transfer of $" + amount);
            System.out.println("Account withdrawn from balance is $" + withdrawFromAccount.getBalance());
            System.out.println("Account deposited to balance is $" + depositToAccount.getBalance());
        } else {
            System.out.println("Insufficient funds. Your current balance is $" + withdrawFromAccount.getBalance()
                    + ". $" + amount + " is greater than the maximum of 50% of the current balance allowed to"
                    + " be transferred.");
        }
    }
}

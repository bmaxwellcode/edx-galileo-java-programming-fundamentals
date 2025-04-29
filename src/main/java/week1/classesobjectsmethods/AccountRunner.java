package week1.classesobjectsmethods;

/**
 * AccountRunner class demonstrates the usage and functionality of the Account
 * class.
 * This class shows how to create an Account object and perform banking
 * operations
 * such as deposits and withdrawals.
 */
public class AccountRunner {

    /**
     * Main method to demonstrate Account class functionality.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("===== ACCOUNT DEMONSTRATION =====");

        // Create a new checking account
        Account myAccount = new Account("checking");

        // Display initial account state
        System.out.println("Initial account state:");
        System.out.println(myAccount);

        // Perform a deposit and show updated balance
        System.out.println("\nDepositing $100:");
        myAccount.deposit(100);
        System.out.println(myAccount);

        // Perform a withdrawal and show updated balance
        System.out.println("\nWithdrawing $99:");
        myAccount.withdraw(99);
        System.out.println(myAccount);

        // Additional demonstration - you could add more operations here
        System.out.println("\nAttempting to withdraw more than balance:");
        myAccount.withdraw(10); // Should show insufficient funds or similar message
        System.out.println(myAccount);
    }
}
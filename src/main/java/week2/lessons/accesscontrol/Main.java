package main2.week2.lessons.accesscontrol;

import main2.week2.lessons.accesscontrol.atm.ATM;
import main2.week2.lessons.accesscontrol.bank.BankAccount;
import main2.week2.lessons.accesscontrol.bank.BankTeller;

/**
 * Main demonstration class for the banking access control system.
 * 
 * This class demonstrates Java's access control mechanisms:
 * 
 * At class level:
 * - public: accessible outside package defined in
 * - package-private: class inaccessible if outside package the class is defined
 * (default if no modifier specified)
 * 
 * At the member level:
 * - public: offers accessibility outside class defined in
 * - package-private: offers access only to classes within the same package
 * (default if no modifier specified)
 * - private: only offers access to the methods within the class
 * - protected: accessible only to own package and subclasses in other packages
 * 
 * The "final" keyword can be used to define a field or method that cannot be
 * overridden
 */
public class Main {
    /**
     * Main method demonstrates banking operations with various access levels.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create bank accounts
        BankAccount a = new BankAccount(1234, 100);
        BankAccount b = new BankAccount(1234, 200);

        // Perform operations through a bank teller
        BankTeller john = new BankTeller();
        john.deposit(a, 100);
        john.transfer(a, b, 50);

        // Perform operations through an ATM in a different package
        ATM xyz = new ATM(222);
        xyz.withdraw(b, 100);
    }
}

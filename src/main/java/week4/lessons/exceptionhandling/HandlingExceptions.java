package week4.lessons.exceptionhandling;

/**
 * Demonstrates exception handling in Java using a credit card purchase
 * scenario.
 */
public class HandlingExceptions {
    private static final double INITIAL_CREDIT_LIMIT = 2000.00;
    private static final int CARD_NUMBER = 62656565;
    private static final double FIRST_PURCHASE_AMOUNT = 1500.00;
    private static final double SECOND_PURCHASE_AMOUNT = 800.00;

    /**
     * Main method that simulates credit card transactions and demonstrates
     * exception handling when the credit limit is exceeded.
     *
     * @param args Command line arguments (not used)
     * @throws Exception If an error occurs during execution
     */
    public static void main(String[] args) throws Exception {
        // Create a credit card with $2000.00 limit
        final CreditCard card = new CreditCard(CARD_NUMBER, INITIAL_CREDIT_LIMIT);
        System.out.println("Credit Card State:");
        System.out.println(card.getCreditState());

        try {
            System.out.printf("\nAttempting purchase of $%.2f%n", FIRST_PURCHASE_AMOUNT);
            card.buy(FIRST_PURCHASE_AMOUNT);

            System.out.println("\nCredit Card State:");
            System.out.println(card.getCreditState());

            System.out.printf("\nAttempting purchase of $%.2f%n", SECOND_PURCHASE_AMOUNT);
            card.buy(SECOND_PURCHASE_AMOUNT);
        } catch (ExceededCreditCardLimitException e) {
            System.out.printf("Purchase declined: Credit limit exceeded by $%.2f%n",
                    e.getExceededAmount());
            e.printStackTrace();
        }
    }
}

/**
 * Represents a credit card with a credit limit and available credit balance.
 */
class CreditCard {
    private final int cardNumber;
    private final double creditLimit;
    private double availableCredit;

    /**
     * Creates a new credit card with the specified number and credit limit.
     *
     * @param cardNumber  The credit card number
     * @param creditLimit The credit limit for this card
     */
    public CreditCard(int cardNumber, double creditLimit) {
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
        this.availableCredit = creditLimit;
    }

    /**
     * Records a payment to the credit card, increasing available credit.
     *
     * @param amount The payment amount
     */
    public void makePayment(double amount) {
        this.availableCredit += amount;
    }

    /**
     * Attempts to make a purchase using the credit card.
     *
     * @param amount The purchase amount
     * @throws ExceededCreditCardLimitException if the purchase would exceed
     *                                          available credit
     */
    public void buy(double amount) throws ExceededCreditCardLimitException {
        if (amount <= availableCredit) {
            this.availableCredit -= amount;
        } else {
            double exceededAmount = amount - availableCredit;
            throw new ExceededCreditCardLimitException(exceededAmount);
        }
    }

    /**
     * Returns a formatted string showing the card's credit state.
     *
     * @return A string containing available credit and credit limit
     */
    public String getCreditState() {
        return String.format("Available Credit: $%.2f, Credit Limit: $%.2f",
                this.availableCredit, this.creditLimit);
    }

    /**
     * Gets the available credit balance.
     *
     * @return The available credit
     */
    public double getAvailableCredit() {
        return this.availableCredit;
    }

    /**
     * Gets the credit limit.
     *
     * @return The credit limit
     */
    public double getCreditLimit() {
        return this.creditLimit;
    }

    /**
     * Gets the card number.
     *
     * @return The card number
     */
    public int getCardNumber() {
        return this.cardNumber;
    }
}

/**
 * Exception thrown when a credit card purchase would exceed the available
 * credit.
 */
class ExceededCreditCardLimitException extends Exception {
    private static final long serialVersionUID = 1L;
    private final double exceededAmount;

    /**
     * Creates a new exception with the specified exceeded amount.
     *
     * @param exceededAmount The amount by which the credit limit was exceeded
     */
    public ExceededCreditCardLimitException(double exceededAmount) {
        super(String.format("Credit limit exceeded by $%.2f", exceededAmount));
        this.exceededAmount = exceededAmount;
    }

    /**
     * Gets the amount by which the credit limit was exceeded.
     *
     * @return The exceeded amount
     */
    public double getExceededAmount() {
        return exceededAmount;
    }
}
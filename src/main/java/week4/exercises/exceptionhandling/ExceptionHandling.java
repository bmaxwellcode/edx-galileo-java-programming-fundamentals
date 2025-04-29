package week4.exercises.exceptionhandling;

/**
 * Demonstrates exception handling with credit card validation and transactions.
 * This class includes custom exceptions for invalid credit card numbers and
 * exceeded credit limits.
 */
public class ExceptionHandling {
   /**
    * Main method to test credit card functionality.
    * Creates a credit card and attempts to make purchases.
    *
    * @param args command line arguments (not used)
    * @throws Exception if any unexpected error occurs
    */
   public static void main(String[] args) throws Exception {
      try {
         // Test valid card
         CreditCard card = new CreditCard(1_123_456_780, 2000.0);
         System.out.println("Credit Card State:");
         System.out.println(card.getCreditState());

         System.out.println("\n\tBuying $1500.00");
         card.buy(1500.00);

         System.out.println("\nCredit Card State:");
         System.out.println(card.getCreditState());

         System.out.println("\n\tBuying $800.00\n");
         // card.buy(800.00);
      } catch (ExceededCreditCardLimitException e) {
         System.out.println("Invalid Buy, Limit Exceeded by " + e.getExceededAmount());
      } catch (InvalidCreditCardNumber e) {
         System.out.println("Invalid credit card number.");
         System.out.println("Error code(s): \n" + e.getErrorType());
      }
   }
}

/**
 * Represents a credit card with available credit and spending limit.
 */
class CreditCard {
   /** The available credit on the card. */
   private double creditAvailable;

   /** The maximum credit limit of the card. */
   private double limit;

   /** The credit card number. */
   private int number;

   /**
    * Constructs a new CreditCard with the specified number and limit.
    *
    * @param number the credit card number
    * @param limit  the credit limit
    * @throws InvalidCreditCardNumber if the card number is invalid
    */
   public CreditCard(int number, double limit) throws InvalidCreditCardNumber {
      InvalidCreditCardNumber validator = new InvalidCreditCardNumber(number);
      String errorCodes = validator.getErrorType();
      if (!errorCodes.isEmpty()) {
         throw validator;
      }

      this.number = number;
      this.creditAvailable = limit;
      this.limit = limit;
   }

   /**
    * Makes a payment to the credit card.
    *
    * @param amount the amount to pay
    */
   public void paidCreditCard(double amount) {
      creditAvailable += amount;
   }

   /**
    * Attempts to make a purchase with the credit card.
    *
    * @param amount the purchase amount
    * @throws ExceededCreditCardLimitException if the purchase exceeds available
    *                                          credit
    */
   public void buy(double amount) throws ExceededCreditCardLimitException {
      if (amount <= creditAvailable) {
         this.creditAvailable -= amount;
      } else {
         double exceeded = amount - creditAvailable;
         throw new ExceededCreditCardLimitException(exceeded);
      }
   }

   /**
    * Gets the current credit card state.
    *
    * @return a string describing the current credit state
    */
   public String getCreditState() {
      return "Credit Available: $" + this.creditAvailable + " Credit Limit: $" + this.limit;
   }

   /**
    * Gets the available credit.
    *
    * @return the available credit amount
    */
   public double getCreditAvailable() {
      return this.creditAvailable;
   }

   /**
    * Gets the credit limit.
    *
    * @return the credit limit amount
    */
   public double getLimit() {
      return this.limit;
   }

   /**
    * Gets the credit card number.
    *
    * @return the credit card number
    */
   public int getNumber() {
      return this.number;
   }
}

/**
 * Exception thrown when a purchase exceeds the available credit limit.
 */
class ExceededCreditCardLimitException extends Exception {
   /** The amount by which the purchase exceeded the limit. */
   private final double exceededAmount;

   /**
    * Constructs a new ExceededCreditCardLimitException.
    *
    * @param exceededAmount the amount by which the purchase exceeded the limit
    */
   public ExceededCreditCardLimitException(double exceededAmount) {
      this.exceededAmount = exceededAmount;
   }

   /**
    * Gets the exceeded amount.
    *
    * @return the amount by which the purchase exceeded the limit
    */
   public double getExceededAmount() {
      return exceededAmount;
   }
}

/**
 * Exception thrown when a credit card number is invalid.
 * Validates credit card numbers according to specific rules:
 * - Must have exactly 10 digits
 * - Must be a positive number
 * - Must not start with 0
 * - Must end with an odd number
 */
class InvalidCreditCardNumber extends Exception {
   /** The invalid credit card number. */
   private final int number;

   /**
    * Constructs a new InvalidCreditCardNumber exception.
    *
    * @param number the invalid credit card number
    */
   public InvalidCreditCardNumber(int number) {
      this.number = number;
   }

   /**
    * Gets the error type description for the invalid credit card number.
    *
    * @return a string describing the validation errors
    */
   public String getErrorType() {
      String numStr = String.valueOf(Math.abs(number));
      StringBuilder errors = new StringBuilder();

      // Check number of digits
      if (numStr.length() != 10) {
         errors.append("10 - Does not have 10 digits-- ");
      }

      // Check if positive
      if (number <= 0) {
         errors.append("5 - Is not a positive number-- ");
      }

      // Check if starts with 0
      if (numStr.charAt(0) == '0') {
         errors.append("0 - Starts with 0-- ");
      }

      // Check if ends with odd number
      int lastDigit = Math.abs(number % 10);
      if (lastDigit % 2 == 1) {
         errors.append("2 - Finishes with an odd number-- ");
      }

      return errors.toString();
   }
}
package week3.lessons.solid.dependencyinversion;

/**
 * DependencyInversion - Demonstrates the Dependency Inversion Principle (DIP)
 * 
 * The Dependency Inversion Principle is one of the five SOLID principles and
 * states:
 * 1. High-level modules should not depend on low-level modules. Both should
 * depend on abstractions.
 * 2. Abstractions should not depend on details. Details should depend on
 * abstractions.
 * 
 * This example shows a UserInterface class that depends on abstractions (Input
 * and Output interfaces)
 * rather than concrete implementations (Graphic and CommandLine classes).
 * This design allows the system to be extended with new UI types without
 * modifying the core logic.
 */
public class DependencyInversion {

    public static void main(String[] args) {
        System.out.println("===== Dependency Inversion Principle Demonstration =====\n");

        // Demonstrate UI operations with Graphical Interface
        System.out.println("--- Using Graphical User Interface ---");
        UserInterface.getUserInput(new Graphic());
        UserInterface.sendToUserOutput(new Graphic());

        System.out.println();

        // Demonstrate UI operations with Command Line Interface
        System.out.println("--- Using Command Line Interface ---");
        UserInterface.getUserInput(new CommandLine());
        UserInterface.sendToUserOutput(new CommandLine());

        // Example of how we could easily add support for new interface types
        // without modifying the UserInterface class
        System.out.println();
        System.out.println("--- Using Voice User Interface (example of extensibility) ---");
        UserInterface.getUserInput(new VoiceInterface());
        UserInterface.sendToUserOutput(new VoiceInterface());
    }
}

/**
 * UserInterface - Represents high-level application logic for user interaction
 * 
 * This class demonstrates dependency inversion by:
 * 1. Depending on abstractions (Input and Output interfaces)
 * 2. Being completely decoupled from concrete implementations
 * 3. Allowing new UI types to be added without modifying this class
 */
final class UserInterface {
    // Private constructor prevents instantiation of utility class
    private UserInterface() {
    }

    /**
     * Gets input from the user through the provided input device
     * 
     * @param inputDevice The input device implementation to use
     */
    public static void getUserInput(Input inputDevice) {
        System.out.print("Receiving input: ");
        inputDevice.getInput();
    }

    /**
     * Sends output to the user through the provided output device
     * 
     * @param outputDevice The output device implementation to use
     */
    public static void sendToUserOutput(Output outputDevice) {
        System.out.print("Sending output: ");
        outputDevice.sendOutput();
    }
}

/**
 * Input - Interface for all input device implementations
 * 
 * This abstraction defines what an input device must do
 * without specifying how it's done.
 */
interface Input {
    /**
     * Gets input from a specific device
     */
    void getInput();
}

/**
 * Output - Interface for all output device implementations
 * 
 * This abstraction defines what an output device must do
 * without specifying how it's done.
 */
interface Output {
    /**
     * Sends output to a specific device
     */
    void sendOutput();
}

/**
 * Graphic - Implementation for graphical user interfaces
 * 
 * Provides concrete implementation for both input and output
 * operations using graphical elements.
 */
class Graphic implements Input, Output {
    @Override
    public void getInput() {
        System.out.println("Getting mouse clicks and movement from graphic interface");
    }

    @Override
    public void sendOutput() {
        System.out.println("Displaying data graphically on screen");
    }
}

/**
 * CommandLine - Implementation for command-line/terminal interfaces
 * 
 * Provides concrete implementation for both input and output
 * operations using text commands.
 */
class CommandLine implements Input, Output {
    @Override
    public void getInput() {
        System.out.println("Reading text commands from terminal");
    }

    @Override
    public void sendOutput() {
        System.out.println("Printing text data to terminal");
    }
}

/**
 * VoiceInterface - Implementation for voice-controlled interfaces
 * 
 * Added to demonstrate how the system can be extended with new interface types
 * without modifying existing code (Open/Closed Principle).
 */
class VoiceInterface implements Input, Output {
    @Override
    public void getInput() {
        System.out.println("Processing voice commands through speech recognition");
    }

    @Override
    public void sendOutput() {
        System.out.println("Converting data to speech through text-to-speech engine");
    }
}
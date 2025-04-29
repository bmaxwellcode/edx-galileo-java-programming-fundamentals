package week4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week4.exercises.technologystorex.FunctionalInterfaces;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for Technology Store X.
 * 
 * This class contains test cases for the Technology Store X functionality.
 * All tests in the folder "test" are executed when the "Test" action is
 * invoked.
 */
public class FunctionalInterfacesTest {
    /** The FunctionalInterfaces instance to test. */
    private FunctionalInterfaces activity4;

    /** Output stream to capture console output. */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Sets up the output stream before each test.
     */
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Cleans up the output stream after each test.
     */
    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    public void setUp() {
        // Since we're using static methods, we just need to reset the list
        // No need to create a new instance each time
        FunctionalInterfaces.readProductsFile();

        // Still instantiate for any instance methods you might call
        activity4 = new FunctionalInterfaces();
    }

    /**
     * Tests the printProducts functionality.
     */
    @Test
    public final void testExercise1() {
        FunctionalInterfaces.printProducts();
        assertEquals(
                "Laptop-12GB_RAM-HDD_1T Printer Headphones HDMI-VGA-Adapter Laptop-16GB_RAM-SSD_750GB Scanner Computer-Keyboard AUX_5ft Ink-Cartridge Mouse-Wireless Laptop-8GB_RAM-HDD_500GB USB-microUSB\n",
                outContent.toString());
    }

    /**
     * Tests the filter2 functionality.
     */
    @Test
    public final void testExercise2() {
        FunctionalInterfaces.filter2();
        assertEquals("Headphones Computer-Keyboard Mouse-Wireless\n", outContent.toString());
    }

    /**
     * Tests the filter3 functionality.
     */
    @Test
    public final void testExercise3() {
        FunctionalInterfaces.filter3();
        assertEquals("Printer Headphones AUX_5ft Ink-Cartridge Mouse-Wireless USB-microUSB\n", outContent.toString());
    }

    /**
     * Tests the filter4 functionality.
     */
    @Test
    public final void testExercise4() {
        FunctionalInterfaces.filter4();
        assertEquals("Headphones Computer-Keyboard AUX_5ft Ink-Cartridge Mouse-Wireless USB-microUSB\n",
                outContent.toString());
    }

    /**
     * Tests the filter5 functionality.
     */
    @Test
    public final void testExercise5() {
        FunctionalInterfaces.filter5();
        assertEquals("Laptop-12GB_RAM-HDD_1T Laptop-16GB_RAM-SSD_750GB Laptop-8GB_RAM-HDD_500GB\n",
                outContent.toString());
    }
}

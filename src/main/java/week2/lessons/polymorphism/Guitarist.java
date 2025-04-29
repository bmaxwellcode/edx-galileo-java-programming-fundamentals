package main2.week2.lessons.polymorphism;

/**
 * Guitarist interface defines the basic functionality required for guitar
 * players.
 * 
 * This interface demonstrates:
 * - Interface inheritance (extends PlaySong)
 * - Default method implementation in interfaces (added in Java 8)
 * - How interfaces can build upon other interfaces to create a hierarchy
 */
public interface Guitarist extends PlaySong {
    /**
     * Plays the guitarist's favorite song.
     * This default method demonstrates how interfaces can provide implementation
     * while also using methods from parent interfaces.
     */
    default void playFavoriteSong() {
        System.out.println("Playing my favorite song...");
        playSong("My first song");
    }
}

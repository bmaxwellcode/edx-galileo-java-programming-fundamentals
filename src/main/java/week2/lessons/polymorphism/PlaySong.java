package main2.week2.lessons.polymorphism;

/**
 * PlaySong interface defines the basic functionality for playing musical
 * pieces.
 * 
 * This interface demonstrates:
 * - Default methods in interfaces (introduced in Java 8)
 * - How interfaces can provide implementation that implementing classes inherit
 * - Base functionality that can be extended by other interfaces
 */
public interface PlaySong {
    /**
     * Plays the specified song.
     * This default method provides an implementation that all implementing classes
     * inherit.
     * 
     * @param songName The name of the song to play
     */
    default void playSong(String songName) {
        System.out.println("Playing " + songName);
    }
}

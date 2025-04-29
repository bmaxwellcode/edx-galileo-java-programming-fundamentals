package main2.week2.exercises.librarymanager;

/**
 * eAudioBook interface defines the basic functionality required for electronic
 * audio books.
 * 
 * This interface demonstrates the use of interface contracts in Java.
 * Classes that implement this interface must provide a method for getting the
 * number of tracks in the audio book.
 */
public interface eAudioBook {
    /**
     * Gets the number of audio tracks in the audio book.
     *
     * @return The number of tracks
     */
    int getNumberOfTracks();
}

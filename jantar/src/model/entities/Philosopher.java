package model.entities;

import java.util.concurrent.Semaphore;

/**
 * Represents a philosopher in the Dining Philosophers problem.
 * Each philosopher has a unique ID, name, and two semaphores representing the chopsticks.
 */
public class Philosopher {
    private int philosopherId;
    private String philosopherName;

    // Semaphore that indicates the condition (0 or 1) of the chopsticks available to the respective philosopher
    private Semaphore leftChopstick;
    private Semaphore rightChopstick;

    /**
     * Constructs a Philosopher with the given ID, name, and chopsticks.
     *
     * @param philosopherId the unique ID of the philosopher.
     * @param philosopherName the name of the philosopher.
     * @param leftChopstick the semaphore representing the left chopstick.
     * @param rightChopstick the semaphore representing the right chopstick.
     */
    public Philosopher(int philosopherId, String philosopherName, Semaphore leftChopstick, Semaphore rightChopstick) {
        this.philosopherId = philosopherId;
        this.philosopherName = philosopherName;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    /**
     * Gets the unique ID of the philosopher.
     *
     * @return the philosopher's ID.
     */
    public int getPhilosopherId() {
        return philosopherId;
    }

    /**
     * Gets the name of the philosopher.
     *
     * @return the philosopher's name.
     */
    public String getPhilosopherName() {
        return philosopherName;
    }

    /**
     * Attempts to acquire the left chopstick.
     *
     * @return true if the left chopstick was acquired; false otherwise.
     * @throws InterruptedException if the current thread is interrupted while waiting.
     */
    public boolean tryAcquireLeft() throws InterruptedException {
        return leftChopstick.tryAcquire();
    }

    /**
     * Releases the left chopstick.
     */
    public void releaseLeft() {
        leftChopstick.release();
    }

    /**
     * Attempts to acquire the right chopstick.
     *
     * @return true if the right chopstick was acquired; false otherwise.
     */
    public boolean tryAcquireRight() {
        return rightChopstick.tryAcquire();
    }

    /**
     * Releases the right chopstick.
     */
    public void releaseRight() {
        rightChopstick.release();
    }
}

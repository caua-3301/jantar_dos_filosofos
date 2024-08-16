package model.entities;

/**
 * A Runnable class that simulates the routine of a philosopher in the Dining Philosophers problem.
 * The philosopher alternates between thinking, trying to acquire chopsticks, eating, and returning chopsticks.
 */
public class RoutinePhilosopher implements Runnable {
    private final Philosopher philosopher;

    /**
     * Constructs a RoutinePhilosopher with the given Philosopher object.
     *
     * @param philosopher the Philosopher object that this RoutinePhilosopher will manage.
     */
    public RoutinePhilosopher(Philosopher philosopher) {
        this.philosopher = philosopher;
    }

    @Override
    public void run() {
        tryToCatchChopsticks(philosopher);
    }

    /**
     * Manages the philosopher's attempt to acquire both chopsticks.
     * The philosopher will think, attempt to acquire chopsticks, eat if successful, and then release the chopsticks.
     * If the philosopher cannot acquire both chopsticks, any acquired chopstick is released.
     * This method runs in an infinite loop, simulating the philosopher's routine.
     *
     * @param philosopher the Philosopher object whose chopsticks are being managed.
     */
    public static void tryToCatchChopsticks(Philosopher philosopher) {
        while (true) {
            try {
                System.out.println("Philosopher " + philosopher.getPhilosopherName() + " is thinking");

                boolean acquireLeft = philosopher.tryAcquireLeft();
                boolean acquireRight = philosopher.tryAcquireRight();

                if (acquireLeft && acquireRight) {
                    eating(philosopher);
                    philosopher.releaseLeft();
                    philosopher.releaseRight();
                    System.out.println("Philosopher " + philosopher.getPhilosopherName() + " returned the chopsticks");
                } else {
                    if (acquireLeft) {
                        philosopher.releaseLeft();
                    }
                    if (acquireRight) {
                        philosopher.releaseRight();
                    }
                }

                Thread.sleep(10000); // Waits for 10 seconds before trying again
            } catch (InterruptedException err) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Simulates the eating process of a philosopher.
     * The philosopher eats for a fixed period of 20 seconds.
     *
     * @param philosopher the Philosopher object that is eating.
     */
    public static void eating(Philosopher philosopher) {
        try {
            System.out.println("Philosopher " + philosopher.getPhilosopherName() + " eating for twenty seconds ");
            Thread.sleep(20000); // Eating time
        } catch (InterruptedException err) {
            Thread.currentThread().interrupt();
        }
    }
}

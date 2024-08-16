import util.factories.EntitiesFactory;
import model.entities.Philosopher;
import util.start.StartProcess;
import java.util.concurrent.Semaphore;

/**
 * The main class that sets up and starts the Dining Philosophers simulation.
 * It initializes semaphores, creates philosophers, sets up their routines, and starts the threads.
 */
public class Main {
    /**
     * The entry point of the application. Initializes the simulation and starts the philosopher threads.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an array of semaphores representing the chopsticks.
        Semaphore[] semaphores = EntitiesFactory.createSemaphores();

        // Create an array of philosophers with associated chopsticks (semaphores).
        Philosopher[] philosophers = EntitiesFactory.createPhilosophers(semaphores);

        // Create an array of Runnable objects, each representing a philosopher's routine.
        Runnable[] routinePhilosophers = EntitiesFactory.createRoutinePhilosophers(philosophers);

        // Create an array of threads, each running a philosopher's routine.
        Thread[] philosopherThreads = EntitiesFactory.createThreads(routinePhilosophers);

        // Start all philosopher threads.
        StartProcess.start(philosopherThreads);
    }
}

package util.factories;

import model.entities.Philosopher;
import model.entities.RoutinePhilosopher;
import java.util.concurrent.Semaphore;

/**
 * A factory class that creates and configures objects for the Dining Philosophers simulation.
 * This includes semaphores, philosophers, their routines, and threads.
 */
public class EntitiesFactory {

    private static final int MAX = 5;

    /**
     * Creates an array of semaphores for chopsticks.
     * Each semaphore is initialized with one permit.
     *
     * @return an array of Semaphore objects.
     */
    public static Semaphore[] createSemaphores() {
        Semaphore[] semaphores = new Semaphore[MAX];

        for (int i = 0; i < MAX; i++) {
            semaphores[i] = new Semaphore(1);
        }

        return semaphores;
    }

    /**
     * Creates an array of Philosopher objects.
     * Each philosopher is assigned a unique ID, name, and associated chopsticks (semaphores).
     *
     * @param semaphores an array of Semaphore objects representing chopsticks.
     * @return an array of Philosopher objects.
     */
    public static Philosopher[] createPhilosophers(Semaphore[] semaphores) {
        String[] philosopherNames = {"John Locke", "Francis Bacon", "Richard Lewis", "William Petty", "Nietzsche"};
        Philosopher[] philosophers = new Philosopher[MAX];

        for (int control = 0; control < MAX; control++) {
            int semaphoreId = (control + 1) % MAX;
            philosophers[control] = new Philosopher(control, philosopherNames[control], semaphores[control], semaphores[semaphoreId]);
        }

        return philosophers;
    }

    /**
     * Creates an array of RoutinePhilosopher objects, each representing a philosopher's routine.
     *
     * @param philosophers an array of Philosopher objects.
     * @return an array of RoutinePhilosopher objects.
     */
    public static Runnable[] createRoutinePhilosophers(Philosopher[] philosophers) {
        RoutinePhilosopher[] routinePhilosophers = new RoutinePhilosopher[MAX];

        for (int control = 0; control < MAX; control++) {
            routinePhilosophers[control] = new RoutinePhilosopher(philosophers[control]);
        }

        return routinePhilosophers;
    }

    /**
     * Creates an array of Thread objects, each running a philosopher's routine.
     *
     * @param routinePhilosophers an array of Runnable objects representing philosophers' routines.
     * @return an array of Thread objects.
     */
    public static Thread[] createThreads(Runnable[] routinePhilosophers) {
        Thread[] threads = new Thread[MAX];

        for (int control = 0; control < MAX; control++) {
            threads[control] = new Thread(routinePhilosophers[control]);
        }

        return threads;
    }
}

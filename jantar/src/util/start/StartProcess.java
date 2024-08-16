package util.start;

/**
 * A utility class for starting multiple threads.
 * This class provides a method to start an array of threads.
 */
public class StartProcess {

    /**
     * Starts each thread in the provided array of threads.
     *
     * @param threadPhilosophers an array of Thread objects to be started.
     */
    public static void start(Thread[] threadPhilosophers) {
        for (Thread thread : threadPhilosophers) {
            thread.start();
        }
    }
}

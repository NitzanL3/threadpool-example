import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * This is a Thread Pool App example from week 4
 */
public class ThreadPoolApp {
    public static void main(String[] args) {
        if (args.length < 2) {
            ThreadPoolApp.error();
        }

        try {
            int numberOfJobs = Integer.parseInt(args[2]);
            int numberOfThreads = Integer.parseInt(args[4]);

            if ((numberOfJobs <= 1) || (numberOfThreads <= 1)) {
                ThreadPoolApp.error();
            }

            ExecutorService pool = Executors.newFixedThreadPool(numberOfThreads);

            Job[] jobs = new Job[numberOfJobs];
            for (int i = 0; i < numberOfJobs; i++) {
                jobs[i] = new Job(i); 
 // Create new Job objects
                pool.execute(jobs[i]); // Executes the command at future time
            }

            pool.shutdown(); // Previously submitted tasks are executed, but no new tasks will be accepted.
            System.out.println("Last line: " + Thread.currentThread().getName()); 

        } catch (NumberFormatException e) {
            ThreadPoolApp.error();
        }
    }

    private static void error() {
        System.out.println("ThreadPoolApp must be run with two positive valued " + "integer arguments. The first detailing the number of jobs  " +"the second the number of processing threads in the pool.");
        System.exit(0); 
 // exit program
    }
}
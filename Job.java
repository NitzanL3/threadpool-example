/*
 * This is a Thread Pool example from workshop week 4 
 */

public class Job implements Runnable {
    private int jobNumber;

    Job(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public void run() {
        // Undertake required work, here we will emulate it by sleeping for a period
        System.out.println("Job: " + jobNumber + " is being processed by thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // No catching as example should not experience interruptions
        }

        System.out.println("Job: " + jobNumber + " is ending in thread: " + Thread.currentThread().getName());
    }
}

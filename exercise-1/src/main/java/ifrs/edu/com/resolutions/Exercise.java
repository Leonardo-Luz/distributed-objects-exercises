package ifrs.edu.com.resolutions;

import java.util.ArrayList;
import java.util.List;

class InnerExercise {
    private static final int MAX = 10;
    private static List<Integer> sharedBuffer = new ArrayList<>();

    private static final Object lock = new Object();

    public void Consumer() throws InterruptedException {
        int min = 500;
        int max = 2000;
        long waitTime;

        synchronized (lock) {
            do {
                waitTime = Math.round(Math.random() * (max - min) + min);

                if (sharedBuffer.size() > 0) {
                    System.out.println("Waiting time of " + waitTime + " milliseconds to consume...");
                    Thread.sleep(waitTime);

                    Integer removed = sharedBuffer.remove((int) 0);
                    System.out.println("Consumed " + removed + " from the buffer, current size: " + sharedBuffer.size()
                            + "\n");
                    lock.notify();
                } else {
                    System.out.println("Current buffer is empty, waiting for producer...\n");
                    lock.wait();
                    System.out.println("Returning to consume!\n");
                }
            } while (true);
        }

    }

    public void Producer() throws InterruptedException {
        int min = 500;
        int max = 2000;
        long waitTime;
        int value;

        synchronized (lock) {
            do {
                waitTime = Math.round(Math.random() * (max - min) + min);
                value = (int) (Math.random() * 1000);

                if (sharedBuffer.size() < MAX) {
                    System.out.println("Waiting time of " + waitTime + " milliseconds to produce...");
                    Thread.sleep(waitTime);

                    sharedBuffer.add(value);
                    System.out
                            .println("Added " + value + " to the buffer, current size: " + sharedBuffer.size() + "\n");
                    lock.notify();
                } else {
                    System.out.println("Current buffer is full, waiting for consumer...");
                    lock.wait();
                    System.out.println("Returning to produce!\n");
                }
            } while (true);
        }
    }
}

public class Exercise {
    private static InnerExercise resolution = new InnerExercise();

    public void Start() {
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    resolution.Producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    resolution.Consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}

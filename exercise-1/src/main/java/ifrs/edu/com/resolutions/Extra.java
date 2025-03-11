package ifrs.edu.com.resolutions;

import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Order {
    private UUID id;
    private int preparationTime;

    public Order(UUID id, int preparationTime) {
        this.id = id;
        this.preparationTime = preparationTime;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public UUID getId() {
        return id;
    }
}

class Chef implements Runnable {
    private final BlockingQueue<Order> queue;

    Chef(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }

    void consume(Order order) throws InterruptedException {
        int prepTime = order.getPreparationTime();

        Thread.sleep(prepTime);

        System.out.println("\n=====CHEF=====\n");
        System.out.println("Order of id " + order.getId() + "was completed in "
                + order.getPreparationTime() + " milliseconds!" + "\n");
        System.out.println("=====END=====\n");
    }
}

class Waiter implements Runnable {
    private final BlockingQueue<Order> queue;

    Waiter(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                queue.put(produce());
                System.out.println("Current orders quantity: " + this.queue.size());
            }
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }

    Order produce() throws InterruptedException {
        int min = 1000;
        int max = 2500;
        int prepTime;
        UUID id = UUID.randomUUID();

        prepTime = (int) Math.round(Math.random() * (max - min) + min);

        Thread.sleep(prepTime);
        System.out.println("\n=====WAITER=====\n");
        System.out.println("New order of id " + id.toString() + " arrived in " + prepTime + " milliseconds...\n");

        Order order = new Order(id, (int) prepTime);

        System.out.println("=====END=====\n");
        return order;
    }
}

public class Extra {
    private Scanner scan = new Scanner(System.in);

    public void setup() {
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>(20);

        Thread waiterThread = new Thread(new Waiter(queue));
        Thread chefThread1 = new Thread(new Chef(queue));
        Thread chefThread2 = new Thread(new Chef(queue));

        waiterThread.start();
        chefThread1.start();
        chefThread2.start();

        int option;
        while (true) {
            System.out.println("Input 0 to Cancel: ");
            option = scan.nextInt();

            if (option == 0) {
                waiterThread.interrupt();
                chefThread1.interrupt();
                chefThread2.interrupt();
                break;
            }
        }

        try {
            waiterThread.join();
            chefThread1.join();
            chefThread2.join();
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }
}

package ifrs.edu.com;

import java.util.Scanner;

import ifrs.edu.com.resolutions.Exercise;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option;

        do {
            System.out.println("Choose an option: \n1. Run Exercise 1\n2. Run Extra Exercise\n0. Exit");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    new Exercise().Start();
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (option != 0);
        scan.close();
    }
}

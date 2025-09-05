/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package queue;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Customer class
class Customer {
    private String name;
    private int number;

    public Customer(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + " - " + name;
    }
}

// Main program
public class BankQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Customer> queue = new LinkedList<>();
        int counter = 1; // for auto-incremented customer number
        int choice;

        do {
            System.out.println("\n=== Bank Queue System ===");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. View queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: // Add customer
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    Customer newCustomer = new Customer(name, counter++);
                    queue.add(newCustomer);
                    System.out.println("Added to queue: " + newCustomer);
                    printQueue(queue);
                    break;

                case 2: // Serve customer
                    if (queue.isEmpty()) {
                        System.out.println("No customers in queue.");
                    } else {
                        Customer served = queue.poll();
                        System.out.println("Serving: " + served);
                    }
                    printQueue(queue);
                    break;

                case 3: // View queue
                    printQueue(queue);
                    break;

                case 4: // Exit
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }

    // Helper method to print queue
    public static void printQueue(Queue<Customer> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Current Queue:");
            for (Customer c : queue) {
                System.out.println("- " + c);
            }
        }
    }
}
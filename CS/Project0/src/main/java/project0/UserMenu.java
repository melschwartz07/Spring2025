/**
 * Melanie Schwartz
 * sno122
 */
package project0;

import java.util.Scanner;

public class UserMenu {
    private Scanner scanner;

    // Constructor to initialize user input
    public UserMenu() {
        scanner = new Scanner(System.in);
    }

    // Prompt user for a valid number option
    public int menuDisplay() {
        // Initialize with an invalid option
        int option = -1;
        while (option < 1 || option > 5) {
            try {
                System.out.println("\nWelcome to Grocery List Management! \n");
                System.out.println("1. Add Item to your Grocery List");
                System.out.println("2. Remove Item from your Grocery List");
                System.out.println("3. “Check Off” an Item from your Grocery List");
                System.out.println("4. Display your Grocery List");
                System.out.println("5. Exit");
                System.out.print("\nPlease enter the number of an option from the menu: ");

                option = scanner.nextInt();
                if (option < 1 || option > 5) {
                    System.out.println("Invalid option. Please enter a number between 1 and 5.");
                }
            } catch (Exception e) {
                System.out.println("Invalid option. Please enter a number between 1 and 5.");
                // Clear invalid input
                scanner.nextLine();
            }
        }
        return option;
    }


    // Prompts the user for either an item name or item number
    public String promptForItemNameOrNumber(String action) {
        scanner.nextLine();
        System.out.print("Enter the item name or number to " + action + ": ");
        // Return the input as a string
        return scanner.nextLine().trim();
    }

    // Display message to the user
    public void displayMessage(String message) {
        System.out.println(message);
    }
}

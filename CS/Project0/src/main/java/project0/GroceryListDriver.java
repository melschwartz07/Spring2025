/**
 * Melanie Schwartz
 * sno122
 */
package project0;

public class GroceryListDriver {
    private List groceryList;
    private UserMenu userChoice;

    // Constructor to initialize list and user menu
    public GroceryListDriver() {
        groceryList = new List();
        userChoice = new UserMenu();
    }

    // Begin prompting user for inputs
    public void start() {
        int option;
        do {
            // Display the menu and get the user's choice
            option = userChoice.menuDisplay();
            // Handle the chosen action
            handleOption(option);
        } while (option != 5);
        userChoice.displayMessage("Goodbye!");
        // Print the final grocery list upon termination
        groceryList.printList();
    }

    // Handle actions based on the selected menu option
    private void handleOption(int option) {
        switch (option) {
            case 1:
                // Add Item to list
                String itemToAdd = userChoice.promptForItemNameOrNumber("add");
                groceryList.addItem(itemToAdd);
                break;
            case 2:
                // Remove Item by name or number if it exists
                String itemToRemove = userChoice.promptForItemNameOrNumber("remove");
                boolean removed = groceryList.removeItem(itemToRemove);
                if (removed) {
                    userChoice.displayMessage("Item removed from the list.");
                } else {
                    userChoice.displayMessage("Item not found in the list.");
                }
                break;
            case 3:
                // Check Off Item by name or number if exists
                String itemToCheckOff = userChoice.promptForItemNameOrNumber("check off");
                boolean checkedOff = groceryList.checkOffItem(itemToCheckOff);
                if (checkedOff) {
                    userChoice.displayMessage("Item checked off.");
                } else {
                    userChoice.displayMessage("Item not found in the list.");
                }
                break;
            case 4:
                // Print Grocery List and total number of items
                groceryList.printList();
                break;
            case 5:
                // Terminate
                break;
            default:
                userChoice.displayMessage("Invalid option, please try again.");
        }
    }

    public static void main(String[] args) {
        // Initialize the list driver
        GroceryListDriver driver = new GroceryListDriver();
        driver.start();
    }
}

/**
 * Melanie Schwartz
 * sno122
 */
package project0;

import java.util.ArrayList;

public class List {
    private ArrayList<Items> items;

    // Initialize the list of items
    public List() {
        items = new ArrayList<>();
    }

    // Add an item if it doesn't exist
    public void addItem(String item) {
        if (getItemIndex(item) != -1) {
            System.out.println("Item already exists in the list.");
            return;
        }
        items.add(new Items(item));
    }

    // Check off an item by number or name
    public boolean checkOffItem(String input) {
        int index = getItemIndex(input);
        if (index != -1) {
            items.get(index).checkOff();
            return true;
        }
        return false;
    }

    // Remove an item by number or name
    public boolean removeItem(String input) {
        int index = getItemIndex(input);
        if (index != -1) {
            items.remove(index);
            return true;
        }
        return false;
    }

    // Print the grocery list with the number of items
    public void printList() {
        System.out.println("\nGrocery List:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).toString());
        }
        System.out.println("\n Total items: " + items.size());
    }

    // Get the index of the item based on its name or number
    public int getItemIndex(String input) {
        try {
            // If the input is a number, looks for the index
            int index = Integer.parseInt(input) - 1;
            if (index >= 0 && index < items.size()) {
                return index;
            }
        } catch (NumberFormatException e) {
            // search for item as name
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getItem().equalsIgnoreCase(input)) {
                    return i;
                }
            }
        }
        return -1;
    }
}

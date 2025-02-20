/**
 * Melanie Schwartz
 * sno122
 */
package project0;

public class Items {
    private String item;
    private boolean retrieved;

    // Store item name in lowercase and initial condition to false
    public Items(String item) {
        this.item = item.toLowerCase();
        this.retrieved = false;
    }

    // Item accessor
    public String getItem() {
        return item;
    }

    // Mark item as 'checked off'
    public void checkOff() {
        this.retrieved = true;
    }

    // String concatenation of the item given its status
    @Override
    public String toString() {
        String mark;
        if (retrieved) {
            mark = "x";
        } else {
            mark = "-";
        }
        return mark + " " + item;
    }
}

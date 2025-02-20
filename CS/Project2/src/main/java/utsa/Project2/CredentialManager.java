/**
 * Melanie Schwartz
 * sno122
 */
package utsa.Project2;

/**
 * These users should inherit from a generalized class (for ease of data and behavior
 * management). The general class should NOT be able to be instantiated as an Object in the
 * system. Only Patients and Medical Staff should be able to exist as Objects. Both types of users
 * will need to be able to get/return and set/modify all their information/attributes except
 * id and username; the id and username CANNOT be changed once it has been assigned to a user.
 */

// Abstract class to define shared attributes and behaviors for Patients and Medical Staff.
public abstract class CredentialManager {
    protected int id;
    protected String username;
    protected String password;
    protected String name;
    protected String email;

    // Constructor initializing all common attributes
    public CredentialManager(int id, String username, String password, String name, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    // ID getter
    public int getId() {
        return id;
    }

    // Username getter
    public String getUsername() {
        return username;
    }

    // password getter
    public String getPassword() {
        return password;
    }

    // Option to set Password
    public void setPassword(String password) {
        this.password = password;
    }

    // Name getter
    public String getName() {
        return name;
    }

    // Set users name
    public void setName(String name) {
        this.name = name;
    }

    // Email getter
    public String getEmail() {
        return email;
    }

    // email setter
    public void setEmail(String email) {
        this.email = email;
    }

    // Overridden toString method for displaying user attributes
    @Override
    public String toString() {
        return "ID: " + id + ", Username: " + username + ", Name: " + name + ", Email: " + email;
    }
}


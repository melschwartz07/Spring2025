/**
 * Melanie Schwartz
 * sno122
 */
package utsa.Project2;

// Extends the CredentialManager class to inherit common user attributes and behaviors.
public class MedicalStaff extends CredentialManager {
    private String department;

    // Initialize medical staff object with attributes
    public MedicalStaff(int id, String username, String password, String name, String email, String department) {
        super(id, username, password, name, email);
        this.department = department;
    }

    // department getter
    public String getDepartment() {
        return department;
    }

    // department setter
    public void setDepartment(String department) {
        this.department = department;
    }

    // Overridden toString method to include department details.
    @Override
    public String toString() {
        return super.toString() + ", Department: " + department;
    }
}


/**
 * Melanie Schwartz
 * sno122
 */
package utsa.Project2;

// Extends the CredentialManager class to inherit common user attributes and behaviors.
public class Patient extends CredentialManager {
    private String treatmentNotes;

    // Patient attributes
    public Patient(int id, String username, String password, String name, String email, String treatmentNotes) {
        super(id, username, password, name, email);
        this.treatmentNotes = treatmentNotes;
    }

    // notes getter
    public String getTreatmentNotes() {
        return treatmentNotes;
    }

    // notes setter
    public void setTreatmentNotes(String treatmentNotes) {
        this.treatmentNotes = treatmentNotes;
    }

    // Overridden toString method to include treatment notes.
    @Override
    public String toString() {
        return super.toString() + ", Treatment Notes: " + treatmentNotes;
    }
}


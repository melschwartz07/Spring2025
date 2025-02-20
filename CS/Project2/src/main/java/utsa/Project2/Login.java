/**
 * Melanie Schwartz
 * sno122
 */
package utsa.Project2;

import java.io.*;
import java.util.*;

/**
 * Create a Login class that will perform a basic login function. You will be given two files, one that
 * contains all Patients and one that contains all Medical Staff. Create a Login class that will ask a
 * user for their username and password. The class will read the files and check each Patient
 * and/or Medical Staff to determine if BOTH the username and password match a
 * record/line/Patient/Medical Staff in the files. If one is found, then a new user should be created;
 * if no record/line in the files match, then an error message should be printed and the user should
 * be asked to re-enter their username and password
 */

// Handles user authentication by verifying login credentials against patient and medical staff csv
// Reads data from CSV files and creates user objects for authenticated users.
public class Login {
    // Load all patients and check if username and password match
    public static CredentialManager login(String username, String password) throws IOException {
        List<Patient> patients = loadPatients();
        // iterate over existing list of patients
        for (Patient patient : patients) {
            if (patient.getUsername().equals(username) && patient.getPassword().equals(password)) {
                return patient;
            }
        }

        // Load medical staff and check for username/password match
        List<MedicalStaff> staff = loadMedicalStaff();
        // iterate over medical staff list for credentials
        for (MedicalStaff medicalStaff : staff) {
            if (medicalStaff.getUsername().equals(username) && medicalStaff.getPassword().equals(password)) {
                return medicalStaff;
            }
        }

        throw new IllegalArgumentException("Invalid login credentials");
    }

    // load patient.csv
    static List<Patient> loadPatients() throws IOException {
        List<Patient> patients = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("/Users/melanieschwartz/IdeaProjects/Project2/src/main/java/utsa/Project2/patient.csv"));
        String line;

        // Create a new Patient object
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            patients.add(new Patient(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]));
        }

        reader.close();
        return patients;
    }

    // Loads all medical staff from CSV file.
    private static List<MedicalStaff> loadMedicalStaff() throws IOException {
        List<MedicalStaff> staff = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("/Users/melanieschwartz/IdeaProjects/Project2/src/main/java/utsa/Project2/medicalstaff.csv"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            staff.add(new MedicalStaff(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]));
        }

        reader.close();
        return staff;
    }
}


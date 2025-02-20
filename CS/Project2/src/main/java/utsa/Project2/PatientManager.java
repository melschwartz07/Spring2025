/**
 * Melanie Schwartz
 * sno122
 */
package utsa.Project2;

import java.io.*;
import java.util.*;

// Manages patient-related functionality, viewing profiles, editing patients,
// generating reports, and sorting/searching patient data.
public class PatientManager {
    private CredentialManager credentialManager;
    private List<Patient> patients;
    private Patient currentPatient;

    // initialize patient manager
    public PatientManager(CredentialManager credentialManager) throws IOException {
        this.credentialManager = credentialManager;
        this.patients = Login.loadPatients();
        sortPatientsById();
    }

    // Displays the profile of the logged-in user
    public void viewProfile() {
        System.out.println(credentialManager.toString());
    }

    public void viewPatient(int id) {
        if (credentialManager instanceof Patient) {
            System.out.println("Access Denied: Patients can only view their own information.");
            return;
        }

        // Search for the patient by ID using binary search
        Patient foundPatient = searchByID(id);
        if (foundPatient != null) {
            currentPatient = foundPatient;
            System.out.println(currentPatient.toString());
        } else {
            System.out.println("Patient not found.");
        }
    }

    // method allowing Medical Staff to edit patient information
    public void editPatient(int id, String field, String value) throws IOException {
        if (credentialManager instanceof Patient) {
            System.out.println("Error: Only Medical Staff can edit patient information.");
            return;
        }

        // Search for the patient by ID using binary search
        Patient foundPatient = searchByID(id);
        if (foundPatient != null) {
            switch (field.toLowerCase()) {
                case "name":
                    foundPatient.setName(value);
                    break;
                case "email":
                    foundPatient.setEmail(value);
                    break;
                case "treatmentnotes":
                    foundPatient.setTreatmentNotes(value);
                    break;
                default:
                    System.out.println("Invalid");
                    return;
            }

            savePatients();
            System.out.println("Patient updated");
        } else {
            System.out.println("Patient not found");
        }
    }

    // Generates a report based on report type
    public void generateReport(String filename, String reportType) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        switch (reportType.toLowerCase()) {
            case "id":
                sortPatientsById();
                for (Patient patient : patients) {
                    writer.write(patient.getId() + "," + patient.getName() + "," + patient.getEmail() + "\n");
                }
                break;
            case "name":
                sortPatientsByName();
                for (Patient patient : patients) {
                    writer.write(patient.getId() + "," + patient.getName() + "," + patient.getEmail() + "\n");
                }
                break;
            case "email":
                sortPatientsByEmail();
                for (Patient patient : patients) {
                    writer.write(patient.getEmail() + "\n");
                }
                break;
            default:
                System.out.println("Invalid report type.");
                writer.close();
                return;
        }
        writer.close();
        System.out.println("Report generated successfully: " + filename);
    }

    // Save the current list of patients back to the patient CSV file
    private void savePatients() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/melanieschwartz/IdeaProjects/Project2/src/main/java/utsa/Project2/patient.csv"));

        for (Patient patient : patients) {
            writer.write(patient.getId() + "," + patient.getUsername() + "," + patient.getPassword() + ","
                    + patient.getName() + "," + patient.getEmail() + "," + patient.getTreatmentNotes() + "\n");
        }

        writer.close();
    }

    // Sorts patients by ID using bubble sort
    private void sortPatientsById() {
        for (int i = 0; i < patients.size() - 1; i++) {
            for (int j = 0; j < patients.size() - i - 1; j++) {
                if (patients.get(j).getId() > patients.get(j + 1).getId()) {
                    Collections.swap(patients, j, j + 1);
                }
            }
        }
    }

    // Sorts patients by name using  bubble sort
    private void sortPatientsByName() {
        for (int i = 0; i < patients.size() - 1; i++) {
            for (int j = 0; j < patients.size() - i - 1; j++) {
                if (patients.get(j).getName().compareTo(patients.get(j + 1).getName()) > 0) {
                    Collections.swap(patients, j, j + 1);
                }
            }
        }
    }

    // Sorts patients by email using bubble sort
    private void sortPatientsByEmail() {
        for (int i = 0; i < patients.size() - 1; i++) {
            for (int j = 0; j < patients.size() - i - 1; j++) {
                if (patients.get(j).getEmail().compareTo(patients.get(j + 1).getEmail()) > 0) {
                    Collections.swap(patients, j, j + 1);
                }
            }
        }
    }

    // Performs binary search for a patient by ID
    private Patient searchByID(int id) {
        int low = 0;
        int high = patients.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Patient patient = patients.get(mid);
            if (patient.getId() == id) {
                return patient;
            } else if (patient.getId() < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}

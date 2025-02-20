/**
 * Melanie Schwartz
 * sno122
 */
package utsa.Project2;

import java.util.*;

/**
 * There should be a Driver class that will run the main method. The Driver will
 * instantiate/call/execute Login. Upon a successful Login, a Patient Manager object will be
 * returned. The Driver will then utilize the Patient Manager to perform various tasks that the user
 * wishes to perform. The user will be interacted with through menus and text prompts. Some
 * general guidelines/requirements are detailed here about which classes handle which
 * responsibilities/requirements, but it is up to you to decide exactly how the menus/prompts are
 * constructed/formated, exactly what the menus/prompts say, and exactly which classes do the
 * prompting and user input processing.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Username prompt
            System.out.print("Username: ");
            String username = scanner.nextLine();

            // password prompt
            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Authenticate user using the Login class
            CredentialManager credentialManager = Login.login(username, password);
            System.out.println("Login successful!");

            PatientManager manager = new PatientManager(credentialManager);

            while (true) {
                // Console menu options
                System.out.println("\nMenu:");
                System.out.println("1. View Profile");
                System.out.println("2. View Patient (Medical Staff only)");
                System.out.println("3. Edit Patient (Medical Staff only)");
                System.out.println("4. Generate Report");
                System.out.println("5. Exit");
                System.out.print("Choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    manager.viewProfile();
                } else if (choice == 2) {
                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    manager.viewPatient(id);
                } else if (choice == 3) {
                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter field to edit (name, email, treatmentnotes): ");
                    String field = scanner.nextLine();

                    System.out.print("Enter new value: ");
                    String value = scanner.nextLine();

                    manager.editPatient(id, field, value);
                } else if (choice == 4) {
                    System.out.print("Enter filename for the report: ");
                    String filename = scanner.nextLine();

                    System.out.print("Enter report type (id, name, email): ");
                    String reportType = scanner.nextLine();

                    manager.generateReport(filename, reportType);
                } else if (choice == 5) {
                    break;

                // Handle invalid menu input
                } else {
                    System.out.println("Invalid");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

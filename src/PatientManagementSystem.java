import java.util.Scanner;

public class PatientManagementSystem {

    private static Scanner scanner = new Scanner(System.in);

    private static PatientManager patientManager = new PatientManager();
    private static CheckInManager checkInManager = new CheckInManager();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("       PATIENT MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Register Patient");
System.out.println("2. Search Patient");
System.out.println("3. View All Patients");
System.out.println("4. Update Patient Information");
System.out.println("5. Patient Check-In");
System.out.println("6. View Check-In History");
System.out.println("7. Delete Patient ");
System.out.println("8. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
switch (choice) {

    case 1:
        registerPatient();
        break;

    case 2:
        searchPatient();
        break;

    case 3:
        patientManager.displayPatients();
        break;

    case 4:
        updatePatient();
        break;

    case 5:
        patientCheckIn();
        break;

    case 6:
        checkInManager.displayCheckIns();
        break;

    case 7:
        deletePatient();
        break;

    case 8:
        System.out.println("Thank you for using the system!");
        break;

    default:
        System.out.println("Invalid option. Try again.");
}


        } while (choice != 8);

        scanner.close();
    }

    private static void registerPatient() {

    System.out.print("First Name: ");
    String firstName = scanner.nextLine();

    System.out.print("Last Name: ");
    String lastName = scanner.nextLine();

int age;

while (true) {
    System.out.print("Age: ");

    if (scanner.hasNextInt()) {
        age = scanner.nextInt();
        scanner.nextLine();

        if (age > 0 && age <= 120) {
            break;
        } else {
            System.out.println("Please enter an age between 1 and 120.");
        }
    } else {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine();
    }
}

    System.out.print("Gender: ");
    String gender = scanner.nextLine();

    String phone;
    phone = scanner.nextLine().trim();

while (true) {
    System.out.print("Phone Number: ");
    phone = scanner.nextLine().trim();

    if (phone.matches("\\d{10}")) {
        break;
    } else {
        System.out.println("Invalid phone number. Enter exactly 10 digits.");
    }
}
String email;

while (true) {
    System.out.print("Email: ");
    email = scanner.nextLine().trim();

    if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
        break;
    } else {
        System.out.println("Invalid email address. Please try again.");
    }
}

    Patient patient = new Patient(
            null, firstName, lastName, age,
            gender, phone, email
    );

    patientManager.registerPatient(patient);
}

    private static void searchPatient() {

        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine().trim();

        Patient patient = patientManager.findPatient(id);

        if (patient != null) {
            System.out.println("Patient Found!");
            System.out.println("Name: " + patient.getFirstName()
                    + " " + patient.getLastName());
            System.out.println("Age: " + patient.getAge());
            System.out.println("Phone: " + patient.getPhoneNumber());
            System.out.println("Email: " + patient.getEmail());
        } else {
            System.out.println("Patient not found.");
        }
    }

   private static void deletePatient() {

    System.out.print("Enter Patient ID to delete: ");
    String id = scanner.nextLine().trim();

    Patient patient = patientManager.findPatient(id);

    if (patient == null) {
        System.out.println("Patient not found.");
        return;
    }

    System.out.println("Patient Found: "
            + patient.getFirstName() + " "
            + patient.getLastName());

    System.out.print("Are you sure you want to delete this patient? (yes/no): ");
    String confirmation = scanner.nextLine().trim();

    if (confirmation.equalsIgnoreCase("yes")) {

        boolean deleted = patientManager.deletePatient(id);

        if (deleted) {
            System.out.println("Patient deleted successfully!");
        }

    } else {
        System.out.println("Deletion cancelled.");
    }
}
private static void updatePatient() {

    System.out.print("Enter Patient ID: ");
    String id = scanner.nextLine().trim();

    Patient patient = patientManager.findPatient(id);

    if (patient == null) {
        System.out.println("Patient not found.");
        return;
    }

    System.out.println("Enter updated patient information:");

    System.out.print("First Name: ");
    String firstName = scanner.nextLine().trim();

    System.out.print("Last Name: ");
    String lastName = scanner.nextLine();

    int age;
    while (true) {
        System.out.print("Age: ");
        if (scanner.hasNextInt()) {
            age = scanner.nextInt();
            scanner.nextLine();
            if (age > 0 && age <= 120) {
                break;
            } else {
                System.out.println("Please enter an age between 1 and 120.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    System.out.print("Gender: ");
    String gender = scanner.nextLine();

   String phone;

while (true) {
    System.out.print("Phone Number: ");
    phone = scanner.nextLine().trim();

    if (phone.matches("\\d{10}")) {
        break;
    } else {
        System.out.println("Invalid phone number. Enter exactly 10 digits.");
    }
}

String email;

while (true) {
    System.out.print("Email: ");
    email = scanner.nextLine().trim();

    if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
        break;
    } else {
        System.out.println("Invalid email address. Please try again.");
    }
}

    
    boolean updated = patientManager.updatePatient(
            id, firstName, lastName, age,
            gender, phone, email
    );

    if (updated) {
        System.out.println("Patient information updated successfully!");
    }
}
    private static void patientCheckIn() {

        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine().trim();

        Patient patient = patientManager.findPatient(patientId);

        if (patient == null) {
            System.out.println("Patient not found. Register first.");
            return;
        }

        System.out.print("Reason for Visit: ");
        String reason = scanner.nextLine().trim();

        System.out.print("Temperature (°F): ");
double temperature;

while (true) {
    if (scanner.hasNextDouble()) {
        temperature = scanner.nextDouble();
        scanner.nextLine();

        if (temperature >= 90.0 && temperature <= 110.0) {
            break;
        } else {
            System.out.println("Please enter a temperature between 90°F and 110°F.");
        }

    } else {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine();
    }
}


        System.out.print("Heart Rate (bpm): ");
int heartRate;

while (true) {
    if (scanner.hasNextInt()) {
        heartRate = scanner.nextInt();
        scanner.nextLine();

        if (heartRate >= 30 && heartRate <= 220) {
            break;
        } else {
            System.out.println("Please enter a heart rate between 30 and 220 bpm.");
        }
    } else {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine();
    }
}
       String bloodPressure;

while (true) {
    System.out.print("Blood Pressure: ");
    bloodPressure = scanner.nextLine().trim();

    if (bloodPressure.matches("\\d{2,3}/\\d{2,3}")) {
        break;
    } else {
        System.out.println("Invalid format. Enter blood pressure like 120/80.");
    }
}

     String checkInId = "CHK" + System.currentTimeMillis();

CheckIn checkIn = new CheckIn(
        checkInId,
        patientId,
        reason,
        temperature,
        heartRate,
        bloodPressure
);

checkInManager.addCheckIn(checkIn);
}
}


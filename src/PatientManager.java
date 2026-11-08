import java.util.ArrayList;
import java.io.*;
import java.lang.reflect.Field;

public class PatientManager {

    private ArrayList<Patient> patients;
    private final String FILE_NAME = "data/patients.dat";

    // Constructor
    public PatientManager() {
        patients = new ArrayList<>();
        loadPatients();
    }

    // Register a new patient
public void registerPatient(Patient patient) {

    String patientId = generatePatientId();

    patient.setPatientId(patientId);

    patients.add(patient);
    savePatients();

    System.out.println("Patient registered successfully!");
    System.out.println("Patient ID: " + patient.getPatientId());
}
// Generate a unique patient ID
private String generatePatientId() {

    int nextId = 1001;

    for (Patient patient : patients) {
        String id = patient.getPatientId();

        if (id != null && id.startsWith("PAT")) {
            int currentId = Integer.parseInt(id.substring(3));

            if (currentId >= nextId) {
                nextId = currentId + 1;
            }
        }
    }

    return "PAT" + nextId;
}

    // Find patient by ID
    public Patient findPatient(String patientId) {

        for (Patient patient : patients) {

            if (patient.getPatientId().equalsIgnoreCase(patientId)) {
                return patient;
            }
        }

        return null;
    }

    // Display all patients
    public void displayPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }

        for (Patient patient : patients) {

            System.out.println("----------------------------");
            System.out.println("Patient ID: " + patient.getPatientId());
            System.out.println("Name: " + patient.getFirstName()
                    + " " + patient.getLastName());
            System.out.println("Age: " + patient.getAge());
            System.out.println("Gender: " + patient.getGender());
            System.out.println("Phone: " + patient.getPhoneNumber());
            System.out.println("Email: " + patient.getEmail());
        }
    }
// Update existing patient information
public boolean updatePatient(String patientId,
                             String firstName,
                             String lastName,
                             int age,
                             String gender,
                             String phoneNumber,
                             String email) {

    Patient patient = findPatient(patientId);

    if (patient == null) {
        return false;
    }

    try {
        setPatientField(patient, "firstName", firstName);
        setPatientField(patient, "lastName", lastName);
        setPatientField(patient, "age", age);
        setPatientField(patient, "gender", gender);
        setPatientField(patient, "phoneNumber", phoneNumber);
        setPatientField(patient, "email", email);
    } catch (ReflectiveOperationException e) {
        System.out.println("Error updating patient: " + e.getMessage());
        return false;
    }

    savePatients();

    return true;
}

private void setPatientField(Patient patient, String fieldName, Object value)
        throws ReflectiveOperationException {
    Field field = Patient.class.getDeclaredField(fieldName);
    field.setAccessible(true);
    field.set(patient, value);
}public boolean deletePatient(String patientId) {

    Patient patient = findPatient(patientId);

    if (patient == null) {
        return false;
    }

    patients.remove(patient);
    savePatients();

    return true;
}
    // Save patient records
    private void savePatients() {

        try (ObjectOutputStream output =
                new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            output.writeObject(patients);

        } catch (IOException e) {
            System.out.println("Error saving patient records: " + e.getMessage());
        }
    }

    // Load patient records
    @SuppressWarnings("unchecked")
    private void loadPatients() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream input =
                new ObjectInputStream(new FileInputStream(file))) {

            patients = (ArrayList<Patient>) input.readObject();

            System.out.println("Patient records loaded successfully!");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading patient records: " + e.getMessage());
        }
    }
}
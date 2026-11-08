import java.util.ArrayList;
import java.io.*;

public class CheckInManager {

    private ArrayList<CheckIn> checkIns;
    private final String FILE_NAME = "data/checkins.dat";

    // Constructor
    public CheckInManager() {
        checkIns = new ArrayList<>();
        loadCheckIns();
    }

    // Add a patient check-in
    public void addCheckIn(CheckIn checkIn) {

        checkIns.add(checkIn);
        saveCheckIns();

        System.out.println("Patient checked in successfully!");
        System.out.println("Check-In ID: " + checkIn.getCheckInId());
    }

    // Display check-in history
    public void displayCheckIns() {

        if (checkIns.isEmpty()) {
            System.out.println("No check-in records found.");
            return;
        }

        for (CheckIn checkIn : checkIns) {

            System.out.println("----------------------------");
            System.out.println("Check-In ID: " + checkIn.getCheckInId());
            System.out.println("Patient ID: " + checkIn.getPatientId());
            System.out.println("Reason: " + checkIn.getReasonForVisit());
            System.out.println("Temperature: " + checkIn.getTemperature());
            System.out.println("Heart Rate: " + checkIn.getHeartRate());
            System.out.println("Blood Pressure: " + checkIn.getBloodPressure());
            System.out.println("Check-In Time: " + checkIn.getCheckInTime());
        }
    }

    // Save check-in records
    private void saveCheckIns() {

        try (ObjectOutputStream output =
                new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            output.writeObject(checkIns);

        } catch (IOException e) {
            System.out.println("Error saving check-in records: " + e.getMessage());
        }
    }

    // Load check-in records
    @SuppressWarnings("unchecked")
    private void loadCheckIns() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream input =
                new ObjectInputStream(new FileInputStream(file))) {

            checkIns = (ArrayList<CheckIn>) input.readObject();

            System.out.println("Check-in records loaded successfully!");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading check-in records: " + e.getMessage());
        }
    }
}
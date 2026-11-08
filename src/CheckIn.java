import java.io.Serializable;
import java.time.LocalDateTime;

public class CheckIn implements Serializable {

    private static final long serialVersionUID = 1L;

    private String checkInId;
    private String patientId;
    private String reasonForVisit;
    private double temperature;
    private int heartRate;
    private String bloodPressure;
    private LocalDateTime checkInTime;

    // Constructor
    public CheckIn(String checkInId, String patientId,
                   String reasonForVisit, double temperature,
                   int heartRate, String bloodPressure) {

        this.checkInId = checkInId;
        this.patientId = patientId;
        this.reasonForVisit = reasonForVisit;
        this.temperature = temperature;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.checkInTime = LocalDateTime.now();
    }

    public String getCheckInId() {
        return checkInId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }
}
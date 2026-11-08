import java.io.Serializable;

public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    // Patient attributes
    private String patientId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String phoneNumber;
    private String email;

    // Constructor
    public Patient(String patientId, String firstName, String lastName,
                   int age, String gender, String phoneNumber, String email) {

        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
    this.patientId = patientId;
}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

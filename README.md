# Patient Management System

**A Java-Based Patient Information and Check-In Application**

Developed by **Vera Chidinma Enweana**  
Computer Science & Information Systems  
Johnson C. Smith University

---

## About the Project

The Patient Management System is a Java-based console application designed to organize patient information and manage basic patient check-in operations.

This project combines patient registration, record management, and check-in functionality into one application. It demonstrates the use of object-oriented programming, data structures, file handling, data persistence, and input validation.

## Features

### 1. Patient Management
- Register new patients.
- Automatically generate patient IDs.
- Search for patients using their unique IDs.
- View all registered patients.
- Update existing patient information.
- Delete patient records.

### 2. Patient Check-In
- Check in registered patients.
- Record the reason for each visit.
- Record patient temperature.
- Record heart rate.
- Record blood pressure.
- Automatically generate check-in IDs.
- View patient check-in history.

### 3. Data Persistence
- Save patient records using Java serialization.
- Save check-in records to local files.
- Load saved records when the application restarts.

### 4. Input Validation
- Validate patient age.
- Validate phone number format.
- Validate email addresses.
- Validate temperature ranges.
- Validate heart rate ranges.
- Validate blood pressure formatting.

## Technologies Used

- **Programming Language:** Java
- **IDE:** Visual Studio Code
- **Data Structures:** ArrayList
- **Concepts:** Object-Oriented Programming (OOP)
- **Data Storage:** Java Serialization
- **File Handling:** ObjectInputStream and ObjectOutputStream
- **Version Control:** Git and GitHub

## Project Structure

```text
PatientManagementSystem/
│
├── src/
│   ├── Patient.java
│   ├── PatientManager.java
│   ├── CheckIn.java
│   ├── CheckInManager.java
│   └── PatientManagementSystem.java
│
├── data/
│   ├── patients.dat
│   └── checkins.dat
│
├── README.md
└── .gitignore
```

## How to Run the Application

1. Clone or download the repository.
2. Open the project in Visual Studio Code.
3. Ensure Java is installed.
4. Open `PatientManagementSystem.java`.
5. Run the application.
6. Follow the menu instructions in the terminal.

## Learning Objectives

Through this project, I strengthened my understanding of:

- Java classes and objects.
- Encapsulation and object-oriented programming.
- ArrayLists and data structures.
- File input and output.
- Data persistence and serialization.
- Input validation and error handling.
- Building and testing multi-class Java applications.

## Future Improvements

Potential future enhancements include:

- Developing a graphical user interface (GUI).
- Integrating a relational database such as MySQL.
- Implementing user authentication and role-based access.
- Adding automated unit tests.
- Improving patient search and reporting capabilities.

## Disclaimer

This application is an educational software prototype. It is not intended for real patient care or the storage of actual protected health information (PHI).

## Author

**Vera Chidinma Enweana**

Computer Science & Information Systems Student  
Johnson C. Smith University

Interested in software development, healthcare technology, and clinical information systems.

---

*Developed as a personal Java programming project.*

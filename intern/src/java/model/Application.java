package model;

public class Application {
    private int id;
    private int internshipId;
    private int studentId;
    private String status;

    // Default constructor
    public Application() {}

    // Parameterized constructor
    public Application(int id, int internshipId, int studentId, String status) {
        this.id = id;
        this.internshipId = internshipId;
        this.studentId = studentId;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(int internshipId) {
        this.internshipId = internshipId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

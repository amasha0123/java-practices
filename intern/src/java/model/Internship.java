package model;

public class Internship {
    private int id;
    private String title;
    private String description;
    private String deadline;
    private int companyId;

    // Default constructor
    public Internship() {}

    // Parameterized constructor
    public Internship(int id, String title, String description, String deadline, int companyId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.companyId = companyId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}

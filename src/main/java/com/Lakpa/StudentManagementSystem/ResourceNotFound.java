package com.Lakpa.StudentManagementSystem;

public class ResourceNotFound extends RuntimeException {
    private int id;
    private String firstName;

    public ResourceNotFound(String message, int id, String firstName) {
        super(message);
        this.id = id;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
}

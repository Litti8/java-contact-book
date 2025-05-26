package contactBook;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Phone: %s | Email: %s", name, phoneNumber, email);
    }

    // Method to convert contact to file format
    public String toFileFormat() {
        return name + "," + phoneNumber + "," + email;
    }

    // Static method to create contact from file format
    public static Contact fromFileFormat(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            return new Contact(parts[0].trim(), parts[1].trim(), parts[2].trim());
        }
        return null;
    }
}

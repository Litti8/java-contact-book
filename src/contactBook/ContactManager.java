package contactBook;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts;
    private final String fileName = "contacts.txt";

    public ContactManager() {
        this.contacts = new ArrayList<>();
        loadContactsFromFile();
    }

    // Add new contact
    public boolean addContact(Contact contact) {
        if (findContactByName(contact.getName()) != null) {
            return false; // Contact already exists
        }
        contacts.add(contact);
        saveContactsToFile();
        return true;
    }

    // List all contacts
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    // Search contact by name
    public Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    // Search contacts by partial name
    public List<Contact> searchContactsByName(String searchTerm) {
        List<Contact> results = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(contact);
            }
        }
        return results;
    }

    // Delete contact by name
    public boolean deleteContact(String name) {
        Contact contactToRemove = findContactByName(name);
        if (contactToRemove != null) {
            contacts.remove(contactToRemove);
            saveContactsToFile();
            return true;
        }
        return false;
    }

    // Update contact
    public boolean updateContact(String name, String newPhone, String newEmail) {
        Contact contact = findContactByName(name);
        if (contact != null) {
            if (newPhone != null && !newPhone.trim().isEmpty()) {
                contact.setPhoneNumber(newPhone);
            }
            if (newEmail != null && !newEmail.trim().isEmpty()) {
                contact.setEmail(newEmail);
            }
            saveContactsToFile();
            return true;
        }
        return false;
    }

    // Get total number of contacts
    public int getContactCount() {
        return contacts.size();
    }

    // Save contacts to file
    private void saveContactsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Contact contact : contacts) {
                writer.println(contact.toFileFormat());
            }
        } catch (IOException e) {
            System.err.println("Error saving contacts to file: " + e.getMessage());
        }
    }

    // Load contacts from file
    private void loadContactsFromFile() {
        File file = new File(fileName);
        if (!file.exists()) {
            return; // File doesn't exist yet, that's okay
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Contact contact = Contact.fromFileFormat(line);
                if (contact != null) {
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading contacts from file: " + e.getMessage());
        }
    }
}
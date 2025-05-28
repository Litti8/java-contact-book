package contactBook;

import java.util.List;
import java.util.Scanner;

public class ContactAgendaApp {
    private ContactManager contactManager;
    private Scanner scanner;

    public ContactAgendaApp() {
        this.contactManager = new ContactManager();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("=== CONTACT AGENDA ===");
        System.out.println("Welcome to your Contact Management System!");

        boolean running = true;
        while (running) {
            showMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    listAllContacts();
                    break;
                case 3:
                    searchContacts();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    showStatistics();
                    break;
                case 7:
                    running = false;
                    System.out.println("Thank you for using Contact Agenda. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private void showMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           MAIN MENU");
        System.out.println("=".repeat(40));
        System.out.println("1. Add New Contact");
        System.out.println("2. List All Contacts");
        System.out.println("3. Search Contacts");
        System.out.println("4. Update Contact");
        System.out.println("5. Delete Contact");
        System.out.println("6. Show Statistics");
        System.out.println("7. Exit");
        System.out.println("=".repeat(40));
        System.out.print("Select an option (1-7): ");
    }

    private int getMenuChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void addNewContact() {
        System.out.println("\n--- ADD NEW CONTACT ---");

        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        // Check if contact already exists
        if (contactManager.findContactByName(name) != null) {
            System.out.println("A contact with this name already exists!");
            return;
        }

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();
        if (phone.isEmpty()) {
            System.out.println("Phone number cannot be empty!");
            return;
        }

        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        if (email.isEmpty()) {
            System.out.println("Email cannot be empty!");
            return;
        }

        Contact newContact = new Contact(name, phone, email);
        if (contactManager.addContact(newContact)) {
            System.out.println("✓ Contact added successfully!");
        } else {
            System.out.println("✗ Failed to add contact.");
        }
    }

    private void listAllContacts() {
        System.out.println("\n--- ALL CONTACTS ---");
        List<Contact> contacts = contactManager.getAllContacts();

        if (contacts.isEmpty()) {
            System.out.println("No contacts found. Your agenda is empty.");
            return;
        }

        System.out.println("Total contacts: " + contacts.size());
        System.out.println("-".repeat(60));

        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, contacts.get(i));
        }
    }

    private void searchContacts() {
        System.out.println("\n--- SEARCH CONTACTS ---");
        System.out.print("Enter name to search: ");
        String searchTerm = scanner.nextLine().trim();

        if (searchTerm.isEmpty()) {
            System.out.println("Search term cannot be empty!");
            return;
        }

        List<Contact> results = contactManager.searchContactsByName(searchTerm);

        if (results.isEmpty()) {
            System.out.println("No contacts found matching '" + searchTerm + "'");
        } else {
            System.out.println("Found " + results.size() + " contact(s):");
            System.out.println("-".repeat(60));
            for (int i = 0; i < results.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, results.get(i));
            }
        }
    }

    private void updateContact() {
        System.out.println("\n--- UPDATE CONTACT ---");
        System.out.print("Enter the name of the contact to update: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        Contact contact = contactManager.findContactByName(name);
        if (contact == null) {
            System.out.println("Contact not found!");
            return;
        }

        System.out.println("Current contact information:");
        System.out.println(contact);
        System.out.println("\nEnter new information (press Enter to keep current value):");

        System.out.print("New phone number: ");
        String newPhone = scanner.nextLine().trim();

        System.out.print("New email: ");
        String newEmail = scanner.nextLine().trim();

        if (contactManager.updateContact(name, newPhone, newEmail)) {
            System.out.println("✓ Contact updated successfully!");
        } else {
            System.out.println("✗ Failed to update contact.");
        }
    }

    private void deleteContact() {
        System.out.println("\n--- DELETE CONTACT ---");
        System.out.print("Enter the name of the contact to delete: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        Contact contact = contactManager.findContactByName(name);
        if (contact == null) {
            System.out.println("Contact not found!");
            return;
        }

        System.out.println("Contact to delete:");
        System.out.println(contact);
        System.out.print("Are you sure you want to delete this contact? (y/N): ");

        String confirmation = scanner.nextLine().trim().toLowerCase();
        if (confirmation.equals("y") || confirmation.equals("yes")) {
            if (contactManager.deleteContact(name)) {
                System.out.println("✓ Contact deleted successfully!");
            } else {
                System.out.println("✗ Failed to delete contact.");
            }
        } else {
            System.out.println("Delete operation cancelled.");
        }
    }

    private void showStatistics() {
        System.out.println("\n--- CONTACT STATISTICS ---");
        int totalContacts = contactManager.getContactCount();
        System.out.println("Total contacts in agenda: " + totalContacts);

        if (totalContacts > 0) {
            System.out.println("Data file: contacts.txt");
            System.out.println("Status: All changes are automatically saved");
        } else {
            System.out.println("Your contact agenda is empty.");
        }
    }

    public static void main(String[] args) {
        ContactAgendaApp app = new ContactAgendaApp();
        app.run();
    }
}
# 📞 Contact Agenda - Java Console Application

A comprehensive contact management system built in Java that allows users to manage their contacts through a simple console interface with persistent data storage.

## ✨ Features

- **Add Contacts**: Create new contacts with name, phone number, and email
- **List Contacts**: Display all contacts in a formatted list
- **Search Contacts**: Find contacts by name (partial matching supported)
- **Update Contacts**: Modify existing contact information
- **Delete Contacts**: Remove contacts with confirmation prompt
- **Data Persistence**: Automatic save/load functionality using text files
- **Input Validation**: Comprehensive validation for all user inputs
- **User-Friendly Interface**: Clean, formatted console menus

## 🏗️ Project Structure

```
contactBook/
├── Contact.java           # Contact entity class
├── ContactManager.java    # Business logic and file operations
├── ContactAgendaApp.java  # Main application and user interface
├── contacts.txt          # Data file (auto-generated)
└── README.md             # This file
```

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any text editor or IDE (VS Code, IntelliJ IDEA, Eclipse)

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone https://github.com/Litti8/java-contact-book.git
   cd contactBook
   ```

2. **Compile the Java files**
   ```bash
   javac *.java
   ```

3. **Run the application**
   ```bash
   java ContactAgendaApp
   ```

## 📖 How to Use

### Main Menu Options

1. **Add New Contact**
    - Enter contact name, phone number, and email
    - Duplicate names are automatically prevented

2. **List All Contacts**
    - View all stored contacts in a numbered list
    - Shows total contact count

3. **Search Contacts**
    - Enter partial or full name to find contacts
    - Case-insensitive search

4. **Update Contact**
    - Select contact by name
    - Update phone number and/or email
    - Leave fields empty to keep current values

5. **Delete Contact**
    - Select contact by name
    - Confirmation prompt before deletion

6. **Show Statistics**
    - Display total number of contacts
    - Show data file status

7. **Exit**
    - Safely close the application

### Sample Usage

```
=== CONTACT AGENDA ===
Welcome to your Contact Management System!

========================================
           MAIN MENU
========================================
1. Add New Contact
2. List All Contacts
3. Search Contacts
4. Update Contact
5. Delete Contact
6. Show Statistics
7. Exit
========================================
Select an option (1-7): 1

--- ADD NEW CONTACT ---
Enter name: John Doe
Enter phone number: +1-555-0123
Enter email: john.doe@email.com
✓ Contact added successfully!
```

## 💾 Data Storage

- Contacts are automatically saved to `contacts.txt` after each operation
- Data is loaded automatically when the application starts
- File format: `name,phone,email` (CSV-like structure)
- No manual save required - all changes are persistent

## 🏛️ Architecture

### Classes Overview

#### `Contact.java`
- **Purpose**: Entity class representing a contact
- **Key Features**:
    - Properties: name, phoneNumber, email
    - File format conversion methods
    - String representation for display

#### `ContactManager.java`
- **Purpose**: Business logic and data management
- **Key Features**:
    - CRUD operations (Create, Read, Update, Delete)
    - File I/O operations
    - Search and validation methods
    - Automatic data persistence

#### `ContactAgendaApp.java`
- **Purpose**: User interface and application flow
- **Key Features**:
    - Interactive console menu system
    - Input validation and error handling
    - User-friendly prompts and feedback

## 🔧 Technical Details

- **Language**: Java
- **Java Version**: Compatible with JDK 8+
- **Dependencies**: No external dependencies (uses standard Java libraries)
- **File Format**: Plain text (CSV-like)
- **Architecture Pattern**: MVC-inspired (Model-View-Controller)

## 🛡️ Error Handling

- **File Operations**: Graceful handling of file read/write errors
- **Input Validation**: Prevents empty fields and invalid inputs
- **Duplicate Prevention**: Checks for existing contacts before adding
- **User Confirmation**: Confirmation prompts for destructive operations

## 🎯 Future Enhancements

Potential improvements for future versions:

- [ ] Export contacts to different formats (JSON, XML, CSV)
- [ ] Import contacts from external files
- [ ] Advanced search filters (by phone, email)
- [ ] Contact categories/groups
- [ ] Backup and restore functionality
- [ ] GUI version using JavaFX or Swing
- [ ] Contact photo support
- [ ] Multiple phone numbers per contact

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

Created as a Java learning project demonstrating:
- Object-oriented programming principles
- File I/O operations
- Console application development
- Data persistence
- User input validation

---

**Note**: This is a console-based application designed for educational purposes and practical contact management needs.
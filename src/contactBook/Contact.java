package contactBook;

public class Contact {

    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {

        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

   @Override
    public String toString() {
        return "%s | %s | %s".formatted(name, phone, email);
   }
}

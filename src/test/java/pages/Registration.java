package pages;

public class Registration {
    private String firstName;
    private String lastName;
    private String email;
    private String passWorld;

    public Registration(String firstName, String lastName, String email, String passWorld) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passWorld = passWorld;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassWorld() {
        return passWorld;
    }
}

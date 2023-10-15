package User;

public class Librarian extends User {
    private String staffID;

    public Librarian(String username, String password, String firstName, String lastName, String email, String phoneNumber, String staffID) {
        super(username, password, firstName, lastName, email, phoneNumber);
        this.staffID = staffID;
    }

    @Override
    public String toString() {
        return super.toString() + ", Librarian{" +
                "staffID='" + staffID + '\'' +
                '}';
    }
}


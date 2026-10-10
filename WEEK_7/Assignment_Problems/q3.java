package WEEK_7.Assignment_Problems;

public class q3 {
    private final String firstName;
    private final String lastNameInitial;

    public q3(String fullName) {
        // Split text apart wherever a space appears[cite: 3]
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        // Take the last name's initial[cite: 3]
        this.lastNameInitial = parts[1].substring(0, 1) + ".";
    }

    public String getNickname() {
        return firstName + " " + lastNameInitial;
    }

    public static void main(String[] args) {
        q3 tag = new q3("Maria Gomez");
        System.out.println("Nickname -> " + tag.getNickname()); // Expected: "Maria G."
    }
}
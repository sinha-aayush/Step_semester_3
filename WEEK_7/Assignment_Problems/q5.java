package WEEK_7.Assignment_Problems;

public class q5 {
    private final String[] presentStudents;
    private int count;

    public q5(int maxSize) {
        this.presentStudents = new String[maxSize];
        this.count = 0;
    }

    public void markPresent(String name) {
        // Check whether it is already in the array to avoid counting twice[cite: 5]
        if (isPresent(name)) {
            return;
        }
        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        q5 sheet = new q5(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // Duplicate, ignored[cite: 5]
        
        System.out.println("Present Count -> " + sheet.getPresentCount()); // Expected: 2
        System.out.println("Is 'Ben' present? -> " + sheet.isPresent("Ben")); // Expected: true
        System.out.println("Is 'Chen' present? -> " + sheet.isPresent("Chen")); // Expected: false
    }
}
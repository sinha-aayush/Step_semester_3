package WEEK_7.Assignment_Problems;

public class q4 {
    private final int lockerNumber;
    private String combinationCode;

    public q4(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        // Check the old code first before touching the field[cite: 4]
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            return true;
        }
        return false; // Rejected if wrong current code[cite: 4]
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        q4 l = new q4(101, "1234");
        
        boolean res1 = l.changeCode("1234", "5678");
        System.out.println("Change with '1234' -> " + (res1 ? "success" : "rejected")); // Expected: success
        
        boolean res2 = l.changeCode("0000", "9999");
        System.out.println("Change with '0000' -> " + (res2 ? "success" : "rejected, code is still '5678'")); // Expected: rejected
    }
}
package Practice_Problems;

class mPN {

    public static String maskPhoneNumber(String phone) {
        // Validate length and numeric characters
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Build masked string
        String last4Digits = phone.substring(6);
        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.append("-");
        sb.append(last4Digits);

        return sb.toString();
    }

    public static class q4{
    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}
}

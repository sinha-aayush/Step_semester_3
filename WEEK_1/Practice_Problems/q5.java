package Practice_Problems;

public class q5 {

    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        String reversed = "";
        
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed += chars[i];
        }
        
        return reversed;
    }

    public static void main(String[] args) {
        String originalName = "Sunil";
        String reversedName = reverseCustomerName(originalName);

        System.out.println("Original Name: " + originalName);
        System.out.println("Reversed Name: " + reversedName);
    }
}

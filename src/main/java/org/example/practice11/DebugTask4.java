package org.example.practice11;

public class DebugTask4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(null));
    }

    public static boolean isPalindrome(String str) {
        if (str == null) return false; //null обрабатывается осознанно
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}

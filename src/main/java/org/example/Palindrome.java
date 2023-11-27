package org.example;

public class Palindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 1 || s.isEmpty()) return false;
        return new StringBuilder(s).reverse().toString().replaceAll(" ", "").equalsIgnoreCase(s.replaceAll(" ", ""));
    }
}

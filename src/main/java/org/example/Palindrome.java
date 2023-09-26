package org.example;

public class Palindrome {
    public boolean isPalindrome(String s) {
        if(s.isEmpty() || s.length() == 1) return false;
        return new StringBuilder(s).reverse().toString().equalsIgnoreCase(s);
    }
}

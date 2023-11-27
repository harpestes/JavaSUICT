import org.example.Palindrome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PalindromeTest {
    Palindrome palindrome;

    @BeforeEach
    void setUp() {
        palindrome = new Palindrome();
    }

    @Test
    void isPalindrome() {
        assertFalse(palindrome.isPalindrome(null));
        assertFalse(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("radar"));
        assertFalse(palindrome.isPalindrome("banana"));
        assertTrue(palindrome.isPalindrome("hannah"));
        assertTrue(palindrome.isPalindrome("pup"));
        assertTrue(palindrome.isPalindrome("nan"));
        assertFalse(palindrome.isPalindrome("lollipop"));
        assertTrue(palindrome.isPalindrome("eye"));
        assertTrue(palindrome.isPalindrome("6543456"));
        assertTrue(palindrome.isPalindrome("step on no pets"));
        assertTrue(palindrome.isPalindrome("A man a plan a canal Panama"));
    }
}

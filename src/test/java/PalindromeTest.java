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
    void testPalindromeTrue() {
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("raCecaR"));
        assertTrue(palindrome.isPalindrome("redder"));
        assertTrue(palindrome.isPalindrome("RedDer"));
    }

    @Test
    void testPalindromeFalse() {
        assertFalse(palindrome.isPalindrome("test"));
    }

    @Test
    void testPalindromeEmpty() {
        assertFalse(palindrome.isPalindrome(""));
    }

    @Test
    void testPalindromeOneCharacter() {
        assertFalse(palindrome.isPalindrome("a"));
    }
}

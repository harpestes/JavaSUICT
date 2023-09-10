import org.example.Book;
import org.example.Library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddToLibrary() {
        assertTrue(library.addToLibrary("Book1", "Author1", 1234567890L, (short) 2020));
        assertFalse(library.addToLibrary("Book2", "Author2", 1234567890L, (short) 2021));
    }

    @Test
    public void testFindBookByName() {
        String name1 = "Book1";
        String name2 = "Book2";

        library.addToLibrary(name1, "Author1", 1234567890L, (short) 2020);
        library.addToLibrary(name2, "Author2", 1234567891L, (short) 2021);

        Book foundBook1 = library.findBookByName(name1);
        assertNotNull(foundBook1);
        assertEquals("Book1", foundBook1.getName());

        Book foundBook2 = library.findBookByName(name2);
        assertNotNull(foundBook2);
        assertEquals("Book2", foundBook2.getName());

        Book notFoundBook = library.findBookByName("Book3");
        assertNull(notFoundBook);
    }

    @Test
    public void testDeleteBookByISBN() {
        long isbn = 1234567890L;
        library.addToLibrary("Book1", "Author1", isbn, (short) 2020);

        Book deletedBook = library.deleteBookByISBN(isbn);
        assertNotNull(deletedBook);
        assertEquals("Book1", deletedBook.getName());

        Book notFoundBook = library.findBookByName("Book1");
        assertNull(notFoundBook);

        Book nonExistentBook = library.deleteBookByISBN(1111111111L);
        assertNull(nonExistentBook);
    }
}


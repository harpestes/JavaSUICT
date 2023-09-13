import org.example.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;


public class LibraryTest {
    private Library library;
    private Patron patron1;
    private Patron patron2;
    private Book book1;
    private Book book2;
    private DVD dvd1;
    private DVD dvd2;

    @Before
    public void setUp() {
        library = new Library();
        patron1 = new Patron("Patron1");
        patron2 = new Patron("Patron2");
        book1 = new Book("Name1", "Author1");
        book2 = new Book("Name2", "Author2");
        dvd1 = new DVD("Name1", 1);
        dvd2 = new DVD("Name2", 2);
    }

    @Test
    public void testRegisterPatron() {
        assertTrue(library.registerPatron(patron1));
        assertFalse(library.registerPatron(patron1)); // Try to register the same patron
    }

    @Test
    public void testLendItem() {
        assertTrue(library.add(book1));
        assertTrue(library.registerPatron(patron1));

        assertTrue(library.lendItem(patron1, book1));
        assertFalse(library.lendItem(patron1, book1)); // Try lending the same item again
    }

    @Test
    public void testReturnItem() {
        assertTrue(library.add(dvd1));
        assertTrue(library.registerPatron(patron1));

        assertTrue(library.lendItem(patron1, dvd1));
        assertNotNull(library.returnItem(patron1, dvd1));
        assertNull(library.returnItem(patron1, dvd1)); // Try returning the same item again
        assertNull(library.returnItem(patron1, dvd2)); // Try returning the wrong item
    }

    @Test
    public void testAdd() {
        assertTrue(library.add(book1));
        assertFalse(library.add(book1)); // Try adding the same item again
    }

    @Test
    public void testRemove() {
        assertTrue(library.add(dvd1));
        assertNotNull(library.remove(dvd1));
        assertNull(library.remove(dvd1)); // Try removing the same item again
    }

    @Test
    public void testListBorrowed() {
        assertTrue(library.add(book1));
        assertTrue(library.add(book2));
        assertTrue(library.registerPatron(patron1));
        assertTrue(library.registerPatron(patron2));

        assertTrue(library.lendItem(patron1, book1));
        assertTrue(library.lendItem(patron2, book2));

        assertEquals(2, library.listBorrowed().size());

        library.returnItem(patron1, book1);
        library.returnItem(patron2, book2);

        assertNull(library.listBorrowed());
    }

    @Test
    public void testListAvailable() {
        assertTrue(library.add(dvd1));
        assertTrue(library.add(dvd2));

        assertEquals(2, library.listAvailable().size());

        assertTrue(library.registerPatron(patron1));

        assertTrue(library.lendItem(patron1, dvd1));

        assertEquals(1, library.listAvailable().size());

        library.returnItem(patron1, dvd1);

        assertEquals(2, library.listAvailable().size());
    }
}


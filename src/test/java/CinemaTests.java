import org.example.Cinema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CinemaTests {
    private Cinema cinema;

    @BeforeEach
    public void setUp() {
        cinema = new Cinema(2, 1, 10);
    }

    @Test
    public void testBookSeats_True() {
        assertTrue(cinema.bookSeats(1, 0, new int[]{0, 1, 2, 3, 4}));
    }

    @Test
    public void testBookSeats_False() {
        assertFalse(cinema.bookSeats(7, 1, new int[]{5}));
        cinema.bookSeats(0, 0, new int[]{0});
        assertFalse(cinema.bookSeats(0, 0, new int[]{0}));
    }

    @Test
    public void testCancelBooking_True() {
        assertTrue(cinema.cancelBooking(0, 0, new int[]{0, 1, 2}));
    }

    @Test
    public void testCancelBooking_False() {
        assertFalse(cinema.cancelBooking(1, 7, new int[]{0, 1, 2}));
    }

    @Test
    public void testCheckAvailability_True() {
        assertTrue(cinema.checkAvailability(0, 5));
    }

    @Test
    public void testCheckAvailability_False() {
        assertFalse(cinema.checkAvailability(1, 100));
        cinema.bookSeats(0, 0, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        assertFalse(cinema.checkAvailability(0, 5));
    }

    @Test
    public void testFindBestAvailable_True() {
        assertArrayEquals(new int[]{0, 5}, cinema.findBestAvailable(0, 1));
        assertArrayEquals(new int[]{0, 4, 5}, cinema.findBestAvailable(0, 2));
    }

    @Test
    public void testFindBestAvailable_ShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> cinema.findBestAvailable(5, 6));
        cinema.bookSeats(0, 0, new int[]{2});
        assertNull(cinema.findBestAvailable(0, 10));
    }

    @Test
    public void testAutoBook_True() {
        assertTrue(cinema.autoBook(0, 3));
    }

    @Test
    public void testAutoBook_ShouldThrow() {
        assertThrows(IllegalArgumentException.class, () ->cinema.autoBook(1, 11));
        cinema.bookSeats(0, 0, new int[]{2});
        assertFalse(cinema.autoBook(0, 3));
    }
}

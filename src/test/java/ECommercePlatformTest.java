import org.example.ECommercePlatform;
import org.example.Order;
import org.example.Product;
import org.example.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.InstanceAlreadyExistsException;
import java.rmi.NoSuchObjectException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ECommercePlatformTest {
    private ECommercePlatform eCommercePlatform;

    @BeforeEach
    void setUp() throws InstanceAlreadyExistsException {
        eCommercePlatform = new ECommercePlatform();
        eCommercePlatform.addUser("TestUser1");
        eCommercePlatform.addUser("TestUser2");
        eCommercePlatform.addUser("TestUser3");

        eCommercePlatform.addProduct("TestProduct1", 999, 100);
        eCommercePlatform.addProduct("TestProduct2", 99, 11);
        eCommercePlatform.addProduct("TestProduct3", 9999, 111);
    }

    @Test
    void getUserById_ShouldSuccessful() throws NoSuchObjectException {
        eCommercePlatform.addUser("TestUser4");
        assertEquals("TestUser4", eCommercePlatform.getUserById(4).getUsername());
    }

    @Test
    void getUserById_ShouldThrowNoSuchObjectException() {
        assertThrows(NoSuchObjectException.class, () -> eCommercePlatform.getUserById(10));
        assertThrows(NoSuchObjectException.class, () -> eCommercePlatform.getUserById(-1));
    }

    @Test
    void getProductById_ShouldSuccessful() throws InstanceAlreadyExistsException, NoSuchObjectException {
        eCommercePlatform.addProduct("TestProduct4", 0, 0);
        assertEquals("TestProduct4", eCommercePlatform.getProductById(4).getName());
    }

    @Test
    void getProductById_ShouldThrowNoSuchObjectException() {
        assertThrows(NoSuchObjectException.class, () -> eCommercePlatform.getProductById(10));
        assertThrows(NoSuchObjectException.class, () -> eCommercePlatform.getProductById(-1));
    }

    @Test
    void addProduct_ShouldThrowInstanceAlreadyExistsException() {
        assertThrows(InstanceAlreadyExistsException.class, () -> eCommercePlatform.addProduct("TestProduct1", 0, 0));
    }

    @Test
    void placeOrder_ShouldSuccessful() throws NoSuchObjectException, InstanceAlreadyExistsException {
        User user = eCommercePlatform.getUserById(1);

        user.addToCart(eCommercePlatform.getProductById(1), 5);
        eCommercePlatform.placeOrder(user.getId());
        Map<Product, Integer> expectedOrderDetails = new HashMap<>(user.getHistoryOfOrders());
        Order actualOrder = eCommercePlatform.getOrders().get(1);

        assertEquals(1, eCommercePlatform.getOrders().size());
        assertEquals(expectedOrderDetails.keySet(), actualOrder.getOrderDetails().keySet());
    }

    @Test
    void placeOrder_ShouldThrowNoSuchObjectException() {
        assertThrows(NoSuchObjectException.class, () -> eCommercePlatform.placeOrder(10));
        assertThrows(NoSuchObjectException.class, () -> eCommercePlatform.placeOrder(-1));
    }

    @Test
    void makeRecommendations_ShouldSuccessful() throws NoSuchObjectException, InstanceAlreadyExistsException {
        User user = eCommercePlatform.getUserById(2);
        user.addToCart(eCommercePlatform.getProductById(1), 1);
        user.addToCart(eCommercePlatform.getProductById(2), 5);
        user.addToCart(eCommercePlatform.getProductById(3), 3);

        eCommercePlatform.placeOrder(user.getId());

        List<Product> expected = Stream.of(eCommercePlatform.getProductById(2), eCommercePlatform.getProductById(3), eCommercePlatform.getProductById(1)).toList();
        assertEquals(expected, eCommercePlatform.makeRecommendations(user.getId()));
    }

    @Test
    void makeRecommendations_ShouldThrowNoSuchObjectException() {
        assertThrows(NoSuchObjectException.class, () -> eCommercePlatform.makeRecommendations(-1));
    }
}

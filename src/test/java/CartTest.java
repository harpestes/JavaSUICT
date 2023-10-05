import org.example.Cart;
import org.example.Order;
import org.example.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartTest {
    private Cart cart;
    @Mock
    private Product product1;
    @Mock
    private Product product2;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
    }

    @Test
    public void testAddToCart() {
        assertTrue(cart.addToCart(product1));
        assertTrue(cart.addToCart(product2));
        assertEquals(2, cart.getProducts().size());
    }

    @Test
    public void testRemoveFromCart() {
        when(product1.getId()).thenReturn("1");
        when(product2.getId()).thenReturn("2");

        cart.addToCart(product1);
        cart.addToCart(product2);

        assertTrue(cart.removeFromCart("1"));
        assertEquals(1, cart.getProducts().size());
        assertFalse(cart.removeFromCart("3"));
    }

    @Test
    public void testPlaceOrder() {
        cart.addToCart(product1);
        cart.addToCart(product2);

        Order order = cart.placeOrder();
        assertEquals(0, cart.getProducts().size());
        assertNotNull(order);
        assertEquals(2, order.getProducts().size());
    }

    @Test
    public void testOrderCanceled() {
        Order order = cart.placeOrder();
        order.cancelOrder();

        assertEquals(Order.Status.CANCELED, order.getStatus());
    }

    @Test
    public void testOrderCompleted() {
        Order order = cart.placeOrder();
        order.completeOrder();

        assertEquals(Order.Status.COMPLETED, order.getStatus());
    }
}

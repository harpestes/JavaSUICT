import org.example.Cart;
import org.example.ECommerceService;
import org.example.Order;
import org.example.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ECommerceServiceTest {
    private ECommerceService eCommerceService;

    @Mock
    private Cart cart;
    @Mock
    private Order order;

    @BeforeEach
    public void setUp() {
        eCommerceService = new ECommerceService(cart, order);
    }

    @Test
    public void testAddToCart() {
        Product product = new Product("Test Product", 100.0f);

        when(cart.getProducts()).thenReturn(new ArrayList<>());

        assertTrue(eCommerceService.addToCart(product));
    }

    @Test
    public void testRemoveFromCart() {
        List<Product> productsInCart = new ArrayList<>();
        Product product1 = new Product("Test Product 1", 100.0f);
        Product product2 = new Product("Test Product 2", 150.0f);
        product1.setId("1");
        product2.setId("2");

        productsInCart.add(product1);
        productsInCart.add(product2);

        when(cart.getProducts()).thenReturn(productsInCart);

        assertTrue(eCommerceService.removeFromCart("1"));
        assertEquals(1, productsInCart.size());
        assertFalse(productsInCart.contains(product1));
    }

    @Test
    public void testPlaceOrder() {
        List<Product> productsInCart = new ArrayList<>();
        Product product1 = new Product("Test Product 1", 100.0f);
        Product product2 = new Product("Test Product 2", 150.0f);
        productsInCart.add(product1);
        productsInCart.add(product2);

        when(cart.getProducts()).thenReturn(productsInCart);

        Order order = eCommerceService.placeOrder();

        assertEquals(Order.Status.IN_PROGRESS, order.getStatus());
    }

    @Test
    public void testCancelOrder() {
        eCommerceService.cancelOrder();

        verify(order).setStatus(Order.Status.CANCELED);
    }

    @Test
    public void testCompleteOrder() {
        eCommerceService.completeOrder();

        verify(order).setStatus(Order.Status.COMPLETED);
    }
}

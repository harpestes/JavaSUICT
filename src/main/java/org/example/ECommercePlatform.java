package org.example;

import lombok.Getter;
import lombok.NonNull;

import javax.management.InstanceAlreadyExistsException;
import java.rmi.NoSuchObjectException;
import java.util.*;

@Getter
public class ECommercePlatform {
    private final Map<Integer, User> users;
    private final Map<Integer, Product> products;
    private final Map<Integer, Order> orders;

    public ECommercePlatform() {
        users = new HashMap<>();
        products = new HashMap<>();
        orders = new HashMap<>();
    }

    public User getUserById(@NonNull Integer id) throws NoSuchObjectException {
        if(!users.containsKey(id)) {
            throw new NoSuchObjectException("There is no such user");
        }
        return users.get(id);
    }

    public Product getProductById(@NonNull Integer id) throws NoSuchObjectException {
        if(!products.containsKey(id)) {
            throw new NoSuchObjectException("There is no such product");
        }
        return products.get(id);
    }

    public User addUser(@NonNull String username) {
        Set<Integer> keys = users.keySet();
        User user = new User(users.size() + 1, username);
        return users.put(keys.size() + 1, user);
    }

    public Product addProduct(@NonNull String name, double price, int stock) throws InstanceAlreadyExistsException {
        for(Integer key : products.keySet()) {
            if(products.get(key).getName().equals(name)) {
                throw new InstanceAlreadyExistsException("Product already exists!");
            }
        }

        Set<Integer> keys = products.keySet();
        Product product = new Product(products.size() + 1, name, price, stock);
        return products.put(keys.size() + 1, product);
    }

    private void updateStock(@NonNull Integer productId, int newStock) throws NoSuchObjectException {
        Product product = products.get(productId);
        if (product == null) {
            throw new NoSuchObjectException("There is no such product");
        }

        product.setStock(newStock);
    }

    public Order placeOrder(Integer userId) {
        User user = users.get(userId);
        Order order = new Order(orders.size() + 1, user.getId(), user.getCart());

        user.clearCart();
        user.updateHistory(order);

        order.getOrderDetails().forEach((product, amount) ->
        {
            if(amount > product.getStock()) {
                throw new IllegalArgumentException("Stock haven't this amount of products \"" + product.getName() + "\"");
            }
            try {
                updateStock(product.getId(), product.getStock() - amount);
            } catch (NoSuchObjectException e) {
                throw new RuntimeException(e);
            }
        });
        return orders.put(order.getId(), order);
    }

    public List<Product> makeRecommendations(Integer userId) {
        User user = users.get(userId);

        ArrayList<Map.Entry<Product, Integer>> toSort = new ArrayList<>(user.getHistoryOfOrders().entrySet());
        toSort.sort(Map.Entry.<Product, Integer>comparingByValue().reversed());

        ArrayList<Product> result = new ArrayList<>();
        for (Map.Entry<Product, Integer> productInteger : toSort) {
            result.add(productInteger.getKey());
        }

        return result;
    }
}

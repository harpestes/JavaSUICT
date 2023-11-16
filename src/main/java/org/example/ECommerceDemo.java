package org.example;

import javax.management.InstanceAlreadyExistsException;
import java.rmi.NoSuchObjectException;

public class ECommerceDemo {
    public static final ECommercePlatform platform = new ECommercePlatform();
    public static void main(String[] args) throws NoSuchObjectException, InstanceAlreadyExistsException {
        platform.addUser("Name1");
        platform.addUser("Name2");
        platform.addUser("Name3");

        platform.addProduct("Product1", 15, 219);
        platform.addProduct("Product2", 0.89, 20000);
        platform.addProduct("Product3", 1000, 15);

        User user = platform.getUserById(3);

        user.addToCart(platform.getProductById(1), 200);
        user.addToCart(platform.getProductById(2), 501);
        user.changeCountOfProducts(platform.getProductById(1), 205);

        System.out.println("Placed order: " + platform.placeOrder(user.getId()));



        user.addToCart(platform.makeRecommendations(user.getId()).get(0), 10);

        System.out.println("Placed order: " + platform.placeOrder(user.getId()));


        System.out.println("\nUsers:");
        platform.getUsers().forEach((key, value) -> System.out.println(value));

        System.out.println("\nProducts:");
        platform.getProducts().forEach((key, value) -> System.out.println(value));

        System.out.println("\nOrders:");
        platform.getOrders().forEach((key, value) -> System.out.println(value));

        System.out.println();
        printSortedProductsByName();
        printSortedProductsByStock();
        printSortedProductsByPrice();
    }

    public static void printSortedProductsByName() {
        System.out.println("Products, sorted by name:");
        platform.getProducts().values()
                .stream()
                .sorted(new NameComparator())
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printSortedProductsByStock() {
        System.out.println("Products, sorted by stock:");
        platform.getProducts().values()
                .stream()
                .sorted(new StockComparator())
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printSortedProductsByPrice() {
        System.out.println("Products, sorted by price:");
        platform.getProducts().values()
                .stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println();
    }
}
package org.example;

import org.example.controller.Client;
import org.example.model.Category;
import org.example.model.Product;
import org.example.model.User;
import org.example.utils.TableConstructor;

import java.util.List;

public class APIDemo {
    public static void main(String[] args) {
        List<User> users = Client.getUsers();
        List<Category> categories = Client.getCategories();
        List<Product> products = Client.getProducts(0, 100);

        TableConstructor.writeDataToExcel("ResultTable.xlsx", products, categories, users);
    }
}
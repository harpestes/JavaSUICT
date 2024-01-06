package org.example.lab9;

import org.example.lab9.controller.Client;
import org.example.lab9.model.Category;
import org.example.lab9.model.Product;
import org.example.lab9.model.User;
import org.example.lab9.utils.TableConstructor;

import java.util.List;

public class APIDemo {
    public static void main(String[] args) {
        List<User> users = Client.getUsers();
        List<Category> categories = Client.getCategories();
        List<Product> products = Client.getProducts(0, 100);

        TableConstructor.writeDataToExcel("ResultTable.xlsx", products, categories, users);
    }
}
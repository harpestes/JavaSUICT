package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import org.example.model.Product;
import org.example.model.User;
import org.example.model.Category;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Client {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final String url = "https://api.escuelajs.co/api/v1/";
    private static final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    @Setter
    private static int defaultLimit = 10;

    public static List<Product> getProducts() {
        return getProducts(0, defaultLimit);
    }

    public static List<Product> getProducts(int offset) {
        return getProducts(offset, defaultLimit);
    }
    public static List<Product> getProducts(int offset, int limit) {
        List<Product> result;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(url + String.format("products?offset=%s&limit=%s", offset, limit))).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            result = mapper.readValue(response.body(), new TypeReference<>(){});
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static List<Category> getCategories() {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(url + "categories")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(response.body(), new TypeReference<>(){});
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> getUsers() {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(url + "users")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(response.body(), new TypeReference<>(){});
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

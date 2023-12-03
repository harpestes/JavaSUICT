package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private static final String url = "https://geocoding-api.open-meteo.com/v1/";

    public static List<City> getCityCoordinates(String... cityNames) {
        List<City> result = new ArrayList<>();

        Arrays.stream(cityNames).forEach(name -> {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(url + String.format("search?name=%s&count=1&language=en&format=json", name))).build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                result.add(mapper.readValue(response.body(), CoordinateSearchResult.class).getResults()[0]);
            } catch (URISyntaxException | IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return result;
    }

    public static WeatherForTheYear getWeatherForYear(City city) {
        try {
            LocalDate currentDate = LocalDate.now();

            HttpRequest request = HttpRequest.newBuilder().uri(new URI(url +
                    String.format("archive?latitude=%s&longitude=%s&start_date=%s&end_date=%s&daily=temperature_2m_mean,precipitation_sum,wind_speed_10m_max,et0_fao_evapotranspiration",
                            city.getLatitude(),
                            city.getLongitude(),
                            currentDate.minusMonths(12),
                            currentDate))).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            WeatherForTheYear result = mapper.readValue(response.body(), WeatherForTheYear.class);
            result.setCity(city);

            return result;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

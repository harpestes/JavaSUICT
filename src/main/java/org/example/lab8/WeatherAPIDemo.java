package org.example.lab8;

import org.example.lab8.controller.Client;
import org.example.lab8.model.City;
import org.example.lab8.model.WeatherForTheMonth;
import org.example.lab8.model.WeatherForTheYear;
import org.example.lab8.service.WeatherAnalyzer;
import org.example.lab8.service.WeatherStatistic;
import org.example.lab8.tableConstructor.Row;
import org.example.lab8.tableConstructor.Table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeatherAPIDemo {
    public static void main(String[] args) {
        String[] cities = new String[]{
                "Kyiv",
                "Lviv",
                "Uzhhorod",
                "Kharkiv",
                "Dnipro",
                "Lutsk",
                "Chernivtsi",
                "Vinnytsia",
                "Kropyvnytskyi"
        };

        List<City> cityCoordinates = Client.getCityCoordinates(cities);

        List<WeatherForTheYear> weatherForCities = new ArrayList<>();
        cityCoordinates.forEach(city -> weatherForCities.add(Client.getWeatherForYear(city)));


        List<WeatherForTheYear> hottest = WeatherAnalyzer.findHottest(10, weatherForCities);
        List<WeatherForTheYear> coldest = WeatherAnalyzer.findColdest(10, weatherForCities);
        List<WeatherForTheYear> humidity = WeatherAnalyzer.findHighestHumidity(10, weatherForCities);
        List<WeatherForTheYear> precipitations = WeatherAnalyzer.findRoutinePrecipitation(7, weatherForCities);
        List<WeatherForTheYear> increased = WeatherAnalyzer.findRoutineTemperatureIncreasing(5, 5, weatherForCities);
        List<WeatherForTheMonth> statistic = WeatherStatistic.calculateMonthlyAverages(Client.getWeatherForYear(cityCoordinates.get(0)).getWeather());
        WeatherForTheMonth windSpeed = WeatherStatistic.getMonthWithHighestAvgWindSpeed(Client.getWeatherForYear(cityCoordinates.get(0)).getWeather());

        printData(hottest, WeatherForTheYear.class);
        printData(coldest, WeatherForTheYear.class);
        printData(humidity, WeatherForTheYear.class);
        printData(precipitations, WeatherForTheYear.class);
        printData(increased, WeatherForTheYear.class);
        printData(statistic, WeatherForTheMonth.class);
        printData(List.of(windSpeed), WeatherForTheMonth.class);
    }

    private static <T> void printData(List<T> list, Class<T> type) {
        Field[] fields = type.getDeclaredFields();

        Table table = new Table();
        Row header = table.createRow();
        Arrays.stream(fields).forEach(field -> header.createCell(field.getName()));

        list.forEach(data -> {
            Row row = table.createRow();
            Arrays.stream(fields).forEach(field -> {
                try {
                    field.setAccessible(true);
                    Object value = field.get(data);
                    field.setAccessible(false);
                    if (field.getType() == String.class) {
                        row.createCell((String) value);
                    } else if (field.getType() == double.class) {
                        row.createCell((double) value);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });
        });

        table.print();
    }
}
package org.example.utils;


import org.example.model.WeatherForTheMonth;
import org.example.model.WeatherForTheYear;

import java.util.List;

public class TableConstructor {
    public static void printWeatherForTheMonthList(List<WeatherForTheMonth> weatherList) {
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%n", "Month", "Avg Temperature", "Avg Precipitation", "Avg Humidity", "Avg Wind Speed");
        System.out.println(String.valueOf('-').repeat(90));

        for (WeatherForTheMonth weatherForTheMonth : weatherList) {
            printWeatherForTheMonth(weatherForTheMonth);
        }

        System.out.println(String.valueOf('-').repeat(90));
    }

    private static void printWeatherForTheMonth(WeatherForTheMonth weatherForTheMonth) {
        System.out.printf("%-15s%-20.2f%-20.2f%-20.2f%-20.2f%n",
                weatherForTheMonth.getMonthNumber() + 1,
                weatherForTheMonth.getAverageTemperature(),
                weatherForTheMonth.getAveragePrecipitation(),
                weatherForTheMonth.getAverageHumidity(),
                weatherForTheMonth.getAverageWindSpeed());
    }

    public static void printWeatherForTheYearList(List<WeatherForTheYear> weatherForTheYearList) {
        System.out.printf("%-30s%-20s%-20s%-20s%n", "City", "Avg Temperature", "Avg Precipitation", "Avg Humidity");
        System.out.println(String.valueOf('-').repeat(82));

        for (WeatherForTheYear weatherForTheYear : weatherForTheYearList) {
            printWeatherForTheYear(weatherForTheYear);
        }

        System.out.println(String.valueOf('-').repeat(82));
    }

    private static void printWeatherForTheYear(WeatherForTheYear weatherForTheYear) {
        String cityName = weatherForTheYear.getCity().getName();
        System.out.printf("%-30s%-20.2f%-20.2f%-20.2f%n",
                cityName,
                weatherForTheYear.getAverageYearTemperature(),
                weatherForTheYear.getAverageYearPrecipitation(),
                weatherForTheYear.getAverageYearHumidity());
    }
}

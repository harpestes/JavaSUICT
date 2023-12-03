package org.example.service;

import org.example.WeatherForTheYear;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WeatherAnalyzer {
    private static final Comparator<WeatherForTheYear> byTemperatureComparator = Comparator.comparingDouble(WeatherForTheYear::getAverageYearTemperature);
    private static final Comparator<WeatherForTheYear> byHumidityComparator = Comparator.comparingDouble(WeatherForTheYear::getAverageYearPrecipitation);

    public static List<WeatherForTheYear> findHottest(int amount, List<WeatherForTheYear> weather) {
        return weather.stream().sorted(byTemperatureComparator.reversed()).limit(amount).toList();
    }

    public static List<WeatherForTheYear> findColdest(int amount, List<WeatherForTheYear> weather) {
        return weather.stream().sorted(byTemperatureComparator).limit(amount).toList();
    }

    public static List<WeatherForTheYear> findHighestHumidity(int amount, List<WeatherForTheYear> weather) {
        return weather.stream().sorted(byHumidityComparator.reversed()).limit(amount).toList();
    }

    public static List<WeatherForTheYear> findRoutinePrecipitation(int amountOfDays, List<WeatherForTheYear> weather) {
        List<WeatherForTheYear> result = new ArrayList<>();
        weather.forEach(cityWeatherForTheYear -> {
            double[] averagePrecipitations = cityWeatherForTheYear.getWeather().getAveragePrecipitationsByDay();
            int counter = 0;

            for(int i = 0; i < averagePrecipitations.length - amountOfDays; i++) {
                counter = (averagePrecipitations[i] > 0) ? counter+1 : 0;
                if(counter == amountOfDays) {
                    result.add(cityWeatherForTheYear);
                    break;
                }
            }
        });

        return result;
    }

    public static List<WeatherForTheYear> findRoutineTemperatureIncreasing(int amountOfDays, double temperatureIncreasing, List<WeatherForTheYear> weather) {
        List<WeatherForTheYear> result = new ArrayList<>();
        weather.forEach(cityWeatherForTheYear -> {
            double[] averageTemperature = cityWeatherForTheYear.getWeather().getAverageTemperatureByDay();

            for(int i = 0; i < averageTemperature.length - amountOfDays; i++) {
                if(averageTemperature[i + amountOfDays] - averageTemperature[i] >= temperatureIncreasing) {
                    result.add(cityWeatherForTheYear);
                    break;
                }
            }
        });

        return result;
    }
}

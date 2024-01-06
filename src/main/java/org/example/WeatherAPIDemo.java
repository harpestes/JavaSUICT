package org.example;

import org.example.controller.Client;
import org.example.model.City;
import org.example.model.WeatherForTheMonth;
import org.example.model.WeatherForTheYear;
import org.example.service.WeatherAnalyzer;
import org.example.service.WeatherStatistic;

import java.util.ArrayList;
import java.util.List;

import static org.example.utils.TableConstructor.printWeatherForTheYearList;
import static org.example.utils.TableConstructor.printWeatherForTheMonthList;

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

        System.out.println("Найгарячіші міста");
        printWeatherForTheYearList(hottest);
        System.out.println("Найхолодніші міста");
        printWeatherForTheYearList(coldest);
        System.out.println("Міста з найвищою вологістю");
        printWeatherForTheYearList(humidity);
        System.out.println("Міста де було більше 7 послідовних днів опадів");
        printWeatherForTheYearList(precipitations);
        System.out.println("Міста в яких температура зросла на щонайменше 5°C протягом 5 послідовних днів");
        printWeatherForTheYearList(increased);

        System.out.println("Глобальна статистика по місяцях"); //1 - January, 2 - February ...
        printWeatherForTheMonthList(statistic);
        System.out.println("Місяць з найвищою середньою швидкістю вітру");
        printWeatherForTheMonthList(List.of(windSpeed));
    }
}
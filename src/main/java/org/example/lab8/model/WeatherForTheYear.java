package org.example.lab8.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.OptionalDouble;

@Getter
public class WeatherForTheYear {
    @Setter
    private City city;
    @JsonProperty("daily")
    private YearWeather weather;
    private double averageYearTemperature;
    private double averageYearPrecipitation;
    private double averageYearHumidity;

    public void countAverage() {
        OptionalDouble average = Arrays.stream(weather.getAverageTemperatureByDay()).average();
        if(average.isPresent()) averageYearTemperature = average.getAsDouble();

        average = Arrays.stream(weather.getAveragePrecipitationsByDay()).average();
        if(average.isPresent()) averageYearPrecipitation = average.getAsDouble();

        average = Arrays.stream(weather.getAverageHumidityByDay()).average();
        if(average.isPresent()) averageYearHumidity = average.getAsDouble();
    }
}

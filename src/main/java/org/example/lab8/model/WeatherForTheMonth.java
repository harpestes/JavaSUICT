package org.example.lab8.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WeatherForTheMonth {
    private Date[] days;
    private double averageTemperature;
    private double averagePrecipitation;
    private double averageHumidity;
    private double averageWindSpeed;
}

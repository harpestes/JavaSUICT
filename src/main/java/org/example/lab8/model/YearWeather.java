package org.example.lab8.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

@Getter
public class YearWeather {
    @JsonProperty("time")
    private Date[] dates;
    @JsonProperty("temperature_2m_mean")
    private double[] averageTemperatureByDay;
    @JsonProperty("precipitation_sum")
    private double[] averagePrecipitationsByDay;
    @JsonProperty("wind_speed_10m_max")
    private double[] maxWindSpeed;
    @JsonProperty("et0_fao_evapotranspiration")
    private double[] averageHumidityByDay;
}

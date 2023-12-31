package org.example.lab8.service;

import org.example.lab8.model.WeatherForTheMonth;
import org.example.lab8.model.YearWeather;

import java.util.*;

public class WeatherStatistic {
    public static List<WeatherForTheMonth> calculateMonthlyAverages(YearWeather yearWeather) {
        Date[] dates = yearWeather.getDates();
        double[] temperatureByDay = yearWeather.getAverageTemperatureByDay();
        double[] precipitationByDay = yearWeather.getAveragePrecipitationsByDay();
        double[] humidityByDay = yearWeather.getAverageHumidityByDay();
        double[] windSpeedByDay = yearWeather.getMaxWindSpeed();

        Map<Integer, WeatherForTheMonth> monthlyDataMap = new HashMap<>();

        for (int i = 0; i < dates.length; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dates[i]);

            int month = calendar.get(Calendar.MONTH);

            WeatherForTheMonth monthData = monthlyDataMap.getOrDefault(month, new WeatherForTheMonth());

            monthData.setMonthNumber(month);
            monthData.setDays(addToNonNullArray(monthData.getDays(), dates[i]));

            if(monthData.getDays().length == 1) {
                monthData.setAverageTemperature(temperatureByDay[i]);
                monthData.setAveragePrecipitation(precipitationByDay[i]);
                monthData.setAverageHumidity(humidityByDay[i]);
                monthData.setAverageWindSpeed(windSpeedByDay[i]);
            }
            else {
                monthData.setAverageTemperature(calculateAverage(monthData.getAverageTemperature(), temperatureByDay[i]));
                monthData.setAveragePrecipitation(calculateAverage(monthData.getAveragePrecipitation(), precipitationByDay[i]));
                monthData.setAverageHumidity(calculateAverage(monthData.getAverageHumidity(), humidityByDay[i]));
                monthData.setAverageWindSpeed(calculateAverage(monthData.getAverageWindSpeed(), windSpeedByDay[i]));
            }

            monthlyDataMap.put(month, monthData);
        }

        List<WeatherForTheMonth> result = new ArrayList<>(12);
        monthlyDataMap.forEach((key, value) -> result.add(value));

        return result;
    }

    public static WeatherForTheMonth getMonthWithHighestAvgWindSpeed(YearWeather yearWeather) {
        List<WeatherForTheMonth> weatherForTheMonths = calculateMonthlyAverages(yearWeather);

        WeatherForTheMonth result = weatherForTheMonths.get(0);
        for(int i = 1; i < weatherForTheMonths.size(); i++) {
            if(result.getAverageWindSpeed() < weatherForTheMonths.get(i).getAverageWindSpeed()) {
                result = weatherForTheMonths.get(i);
            }
        }

        return result;
    }

    private static Date[] addToNonNullArray(Date[] dates, Date value) {
        if (dates == null) {
            return new Date[]{value};
        }
        else {
            Date[] newArray = new Date[dates.length + 1];
            System.arraycopy(dates, 0, newArray, 0, dates.length);
            newArray[dates.length] = value;
            return newArray;
        }
    }

    private static double calculateAverage(double currentAverage, double newValue) {
        return (currentAverage + newValue) / 2;
    }
}

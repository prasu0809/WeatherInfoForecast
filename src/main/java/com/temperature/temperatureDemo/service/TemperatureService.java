package com.temperature.temperatureDemo.service;

import com.temperature.temperatureDemo.client.WeatherClient;
import com.temperature.temperatureDemo.model.WeatherModel;
import com.temperature.temperatureDemo.model.WeatherTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Comparator;

@Component
public class TemperatureService {

    @Autowired
    WeatherClient weatherClient;

    public WeatherTemp getWeather(String cityName){

        WeatherModel weatherModel = weatherClient.getTemperature(cityName);
        Comparator<WeatherModel.Weather> comparator = Comparator.comparing(WeatherModel.Weather::getCreated);
        WeatherModel.Weather weather = weatherModel.getConsolidated_weather().stream().max(comparator).get();
        WeatherTemp weatherTemp = WeatherTemp.builder()
                .max_temp(weather.getMax_temp())
                .min_temp(weather.getMin_temp())
                .the_temp(weather.getThe_temp())
                .build();
        return weatherTemp;
    }

}

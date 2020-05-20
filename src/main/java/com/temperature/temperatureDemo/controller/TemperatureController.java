package com.temperature.temperatureDemo.controller;

import com.temperature.temperatureDemo.model.WeatherModel;
import com.temperature.temperatureDemo.model.WeatherTemp;
import com.temperature.temperatureDemo.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class TemperatureController {

    @Autowired
    TemperatureService temperatureService;

    @GetMapping(value = "/temperature",  produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    WeatherTemp getTemperatureByCityName(@RequestParam("city") String cityName) {
        System.out.println("city is " + cityName);
        return temperatureService.getWeather(cityName);
    }
}

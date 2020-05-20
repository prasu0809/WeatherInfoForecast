package com.temperature.temperatureDemo.client;
import com.temperature.temperatureDemo.model.WeatherModel;
import com.temperature.temperatureDemo.model.WoeidModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class WeatherClient {

    private final String WOEID_URL = "https://www.metaweather.com/api/location/search/?query={city}";
    private final String TEMPERATURE_URL = "https://www.metaweather.com/api/location/{woeid}/";

    public RestTemplate restTemplate;

    @Autowired
    public WeatherClient(@Qualifier("REST_TEMPLATE") RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public WoeidModel getWOEID(String cityName) {

            String weatherUrl = UriComponentsBuilder.fromUriString(WOEID_URL)
                    .buildAndExpand(cityName)
                    .toString();
            return restTemplate.getForEntity(weatherUrl, WoeidModel[].class).getBody()[0];

    }


    public WeatherModel getTemperature(String cityName){
        String woeid = getWOEID(cityName).getWoeid();

        String temperatureUrl =  UriComponentsBuilder.fromUriString(TEMPERATURE_URL)
                .buildAndExpand(woeid)
                .toString();
        return restTemplate.getForEntity(temperatureUrl, WeatherModel.class).getBody();
    }

}

package com.temperature.temperatureDemo.model;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherModel {

    private Collection<Weather> consolidated_weather;

    @Builder
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Weather{

        private LocalDateTime created;
        private String min_temp;
        private String max_temp;
        private String the_temp;

    }

}

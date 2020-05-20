package com.temperature.temperatureDemo.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherTemp {

        private String min_temp;
        private String max_temp;
        private String the_temp;


}

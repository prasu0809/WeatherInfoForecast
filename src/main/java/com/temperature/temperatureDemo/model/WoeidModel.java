package com.temperature.temperatureDemo.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WoeidModel {

    private String title;
    private String location_type;
    private String woeid;
    private String latt_long;

}

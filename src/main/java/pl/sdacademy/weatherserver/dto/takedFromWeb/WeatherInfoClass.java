package pl.sdacademy.weatherserver.dto.takedFromWeb;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class WeatherInfoClass {

    private String cityName;
    private double temperature;
    private LocalDateTime localDateTime;

}

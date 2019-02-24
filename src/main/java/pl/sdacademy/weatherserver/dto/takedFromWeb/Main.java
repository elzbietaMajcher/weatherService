package pl.sdacademy.weatherserver.dto.takedFromWeb;

import lombok.Data;

@Data
public class Main {
    private Double temp;
    private Double pressure;
    private Double humidity;
    private Double temp_min;
    private Double temp_max;
    private Double sea_level;
    private Double grnd_level;

}

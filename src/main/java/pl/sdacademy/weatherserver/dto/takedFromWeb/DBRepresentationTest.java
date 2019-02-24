package pl.sdacademy.weatherserver.dto.takedFromWeb;

import pl.sdacademy.weatherserver.entity.WeatherDB;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DBRepresentationTest {
    public static void main(String[] args) {

        WeatherDB weatherDB1 = new WeatherDB(1L, "Gdansk", -1,LocalDateTime.parse("2019-02-12T13:10:50.516"));
        WeatherDB weatherDB2 = new WeatherDB(2L, "Gdansk", -0,LocalDateTime.parse("2019-02-12T13:29:50.516"));

    }

}

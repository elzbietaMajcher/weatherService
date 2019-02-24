package pl.sdacademy.weatherserver.entity;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
public class WeatherDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private double temperatureC;

    @UpdateTimestamp
    private LocalDateTime timeStamp;

    public WeatherDB(Long id,String city, double temperatureC, LocalDateTime timeStamp) {
        this.id = id;
        this.city = city;
        this.temperatureC = temperatureC;
        this.timeStamp = timeStamp;
    }

    public WeatherDB() {

    }
}

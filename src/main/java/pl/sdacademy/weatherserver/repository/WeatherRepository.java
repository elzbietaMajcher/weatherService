package pl.sdacademy.weatherserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.weatherserver.entity.WeatherDB;

import java.sql.Time;
import java.time.LocalDateTime;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherDB, Long>{

    WeatherDB findByCityAndTimeStampIsAfter (String city, LocalDateTime time);

}

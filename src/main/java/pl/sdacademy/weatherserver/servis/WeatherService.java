package pl.sdacademy.weatherserver.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sdacademy.weatherserver.dto.takedFromWeb.WeatherDto;
import pl.sdacademy.weatherserver.dto.takedFromWeb.WeatherInfoClass;
import pl.sdacademy.weatherserver.entity.WeatherDB;
import pl.sdacademy.weatherserver.repository.WeatherRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;


@Service
public class WeatherService {

    @Value("${openweathermap.apikey}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherRepository weatherRepository;

    private WeatherDto getWeatherFromApiPage(String city) {
        WeatherDto response = restTemplate.
                getForObject("http://api.openweathermap.org/data/2.5/weather?q={city},pl&appid={apikey}&units=metric", WeatherDto.class, city, apiKey);
        return response;
    }

    public void saveInfoInDb(String city) {
        WeatherDto weatherDto = getWeatherFromApiPage(city);
        WeatherDB weatherDB = map(weatherDto);
        weatherRepository.save(weatherDB);
    }

    public WeatherDB map(WeatherDto weatherDto) {
        WeatherDB weatherDB = new WeatherDB();
        weatherDB.setCity(weatherDto.getName());
        weatherDB.setTemperatureC(weatherDto.getMain().getTemp());
        return weatherDB;
    }

    public WeatherInfoClass map(WeatherDB weatherDB) {
        WeatherInfoClass weatherInfo = new WeatherInfoClass();
        weatherInfo.setCityName(weatherDB.getCity());
        weatherInfo.setTemperature(weatherDB.getTemperatureC());
        weatherInfo.setLocalDateTime(weatherDB.getTimeStamp());
        return weatherInfo;
    }

    public WeatherInfoClass getWeatherInfoClass(String city) {
        LocalDateTime time = LocalDateTime.now().minusMinutes(60);
        WeatherDB weatherDB = weatherRepository.findByCityAndTimeStampIsAfter(city, time);
        if (weatherDB == null) {
            saveInfoInDb(city);
          return getWeatherInfoClass(city);
        }else
        return map(weatherDB);
    }
}
/*
REST client/server
==================

Utwórz aplikację zwracającą w postaci REST-owego API dane pogodowe dla wskazanego miasta.
W zwracanych danych powinna znajdować obecna temperatura. Opcjonalnie prognoza pogody dla kolejnych godzin/dni.

Dane źródłowe powinny być pobierane z zewnętrznego API i cache'owane w bazie danych.
Tj. jeśli w ciągu ostatnich 60 minut wystąpiło zapytanie o dane miasto, należy zwrócić dane z bazy.
W przeciwnym wypadku należy pobrać dane z zewnętrznego serwera i zapisać je w lokalnej bazie danych.

Opcjonalnie:
Zaimportuj listę dostępnych miast i użyj jej do walidacji zapytania HTTP
 */

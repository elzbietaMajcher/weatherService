package pl.sdacademy.weatherserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.weatherserver.dto.takedFromWeb.WeatherInfoClass;
import pl.sdacademy.weatherserver.servis.WeatherService;

@RestController
@RequestMapping ("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/test/{city}")
    public WeatherInfoClass getWeatherInfo(@PathVariable String city) {
        return weatherService.getWeatherInfoClass(city);
    }

    @PostMapping("/takeData/{city}")
    public void addDataToDb (@PathVariable String city){
        weatherService.saveInfoInDb(city);
    }

}

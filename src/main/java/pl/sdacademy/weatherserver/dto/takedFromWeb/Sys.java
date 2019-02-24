package pl.sdacademy.weatherserver.dto.takedFromWeb;

import lombok.Data;

@Data
public class Sys {

private int type;
private Long id;
private String message;
private String country;
private Long sunrise;
private Long sunset;

}

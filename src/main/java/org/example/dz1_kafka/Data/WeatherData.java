package org.example.dz1_kafka.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public record WeatherData(
        String location,
        double temperature,
        String conditions,
        String date,
        String timestamp

) {
    private static final Random random = new Random();
    public static WeatherData generate(){
        String loc = Arrays.asList(
                "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань", "Краснодар", "Владивосток"
        ).get(random.nextInt(7));
        double temp =  35 * random.nextDouble();
        String cond = Arrays.asList(
                "солнечно", "облачно", "дождь", "град", "снег"
        ).get(random.nextInt(5));
        LocalDateTime now = LocalDateTime.now();
        String date =  random.nextInt(28) + "." +  random.nextInt(12) + ".2024";
        return new WeatherData(loc, temp, cond, date, now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
    }

    @Override
    public String toString() {
        return "Город: " + location +
                ", Температура: " + temperature + "°C" +
                ", Состояние: " + conditions + ", Дата: " + date;
    }
}
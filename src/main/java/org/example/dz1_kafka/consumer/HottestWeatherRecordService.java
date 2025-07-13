package org.example.dz1_kafka.consumer;

import org.example.dz1_kafka.Data.WeatherData;
import org.example.dz1_kafka.producer.WeatherServiceProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
class HottestWeatherRecordService {
    private static final Logger log = LoggerFactory.getLogger(HottestWeatherRecordService.class);
    Map<String, WeatherData> hottestWeather = new ConcurrentHashMap<>();

    public void updateRecord(WeatherData weather) {
        String location = weather.location();
        double currentTemp = weather.temperature();
        hottestWeather.compute(location, (key, existingRecord) -> {
            if (existingRecord == null || existingRecord.temperature() < currentTemp) {
                log.info("Обновлена самая жаркая температура для города {}: {}°C (было: {})",
                        location,
                        currentTemp,
                        existingRecord != null ? existingRecord.temperature() : "нет данных");
                return weather;
            }
            return existingRecord;
        });
    }

}

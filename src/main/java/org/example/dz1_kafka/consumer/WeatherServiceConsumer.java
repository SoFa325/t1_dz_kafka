package org.example.dz1_kafka.consumer;

import org.example.dz1_kafka.Data.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class WeatherServiceConsumer {
    private static final Logger log = LoggerFactory.getLogger(WeatherServiceConsumer.class);
    @Autowired
    private HottestWeatherRecordService recordService;



    @KafkaListener(topics = "weather-topic", groupId = "weather-group")
    public void consume(WeatherData weather) {
        recordService.updateRecord(weather);
        log.info("\n Получена погода : \n {} \n ",
                weather);

    }
}
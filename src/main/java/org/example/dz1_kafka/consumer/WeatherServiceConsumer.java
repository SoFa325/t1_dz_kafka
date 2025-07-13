package org.example.dz1_kafka.consumer;

import org.example.dz1_kafka.Data.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class WeatherServiceConsumer {
    private static final Logger log = LoggerFactory.getLogger(WeatherServiceConsumer.class);

    @KafkaListener(topics = "weather-topic", groupId = "weather-group")
    public void consume(WeatherData weather) {
        log.info("\n Получена погода : \n {} \n ",
                weather.toString());
    }
}
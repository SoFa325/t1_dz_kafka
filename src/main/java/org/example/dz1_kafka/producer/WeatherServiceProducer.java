package org.example.dz1_kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.example.dz1_kafka.Data.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WeatherServiceProducer {
    private static final Logger log = LoggerFactory.getLogger(WeatherServiceProducer.class);

    @Value("${spring.kafka.topic.weather}")
    private String topic;

    private final KafkaTemplate<String, WeatherData> kafkaTemplate;

    public WeatherServiceProducer(KafkaTemplate<String, WeatherData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 2000)
    public void sendWeatherData() {
        WeatherData weatherData = WeatherData.generate();
        kafkaTemplate.send(topic, weatherData.location(), weatherData);
        log.info("Sent weather data for {}",
                weatherData);
    }
}

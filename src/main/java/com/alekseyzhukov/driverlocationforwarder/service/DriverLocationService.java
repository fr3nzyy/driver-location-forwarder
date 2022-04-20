package com.alekseyzhukov.driverlocationforwarder.service;

import com.alekseyzhukov.driverlocationforwarder.model.Coordinates;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverLocationService {

    @Value(value = "${spring.kafka.coordinates-topic}")
    private String coordinatesTopic;
    Logger LOG = LoggerFactory.getLogger(DriverLocationService.class);


    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void processCoordinates(Coordinates coordinates) {
        System.out.println(coordinates);
        LOG.debug(coordinates.toString());
        kafkaTemplate.send(coordinatesTopic, coordinates);
    }

}

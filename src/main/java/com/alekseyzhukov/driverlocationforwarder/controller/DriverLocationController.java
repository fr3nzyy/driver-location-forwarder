package com.alekseyzhukov.driverlocationforwarder.controller;

import com.alekseyzhukov.driverlocationforwarder.model.Coordinates;
import com.alekseyzhukov.driverlocationforwarder.service.DriverLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("drivers")
@RequiredArgsConstructor
public class DriverLocationController {

    private final DriverLocationService locationService;

    @PatchMapping(path = "{id}/locations", consumes = "application/json")
    public void getLocation(@PathVariable Integer id, @RequestBody Coordinates coordinates) {
        coordinates.setDriverId(id);
        coordinates.setTime(LocalDateTime.now(ZoneId.of("Turkey")));
        locationService.processCoordinates(coordinates);
    }

}

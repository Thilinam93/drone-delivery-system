package com.drone.dronedeliverysystem.controller;

import com.drone.dronedeliverysystem.model.Drone;
import com.drone.dronedeliverysystem.model.Medication;
import com.drone.dronedeliverysystem.service.ApiService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/drones")
@Tag(name = "Dispatcher Controller", description = "Drone Management API")
@RequiredArgsConstructor
public class ApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    private ApiService apiService;

    @PostMapping("/")
    public ResponseEntity<Drone> registerNewDrone(@RequestBody @Valid Drone drone) {
        LOGGER.info("Registering a new drone to the system : [{}]", drone);
        Drone newDrone = apiService.registerNewDrone(drone);
        return new ResponseEntity<>(newDrone, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/medications")
    public ResponseEntity<Drone> loadMedicationToTheDrone(@PathVariable(name = "id") Integer droneId,
                                                   @RequestBody List<Integer> medicationList) {
        LOGGER.info("Load the medication for drone id [{}] with medicines [{}]", droneId, medicationList);
        Drone droneWithMedicine = apiService.loadMedicationToTheDrone(droneId, medicationList);
        return new ResponseEntity<>(droneWithMedicine, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/medications")
    public ResponseEntity<List<Medication>> getLoadedMedicationsByDroneId(@PathVariable(name = "id") Integer droneId) {
        LOGGER.info("Get the loaded medication list for drone id : [{}] ", droneId);
        return ResponseEntity.ok(apiService.getLoadedMedicationsByDroneId(droneId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drone> getDroneDetailsById(@PathVariable(name = "id") Integer droneId) {
        LOGGER.info("Get drone Details for id [{}]", droneId);
        return ResponseEntity.ok(apiService.getDroneDetailsById(droneId));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Drone>> getAllAvailableDrones() {
        LOGGER.info("Get all available drones for load medicine");
        List<Drone> allAvailableDrones = apiService.getAllAvailableDrones();
        return ResponseEntity.ok(allAvailableDrones);
    }

    @GetMapping("/{id}/battery-level")
    public ResponseEntity<Float> getDroneBatteryLevelById(@PathVariable(name = "id") Integer droneId) {
        LOGGER.info("Get the battery level of drone : [{}]", droneId);
        return ResponseEntity.ok(apiService.getDroneBatteryLevelById(droneId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Drone>> getAllDrones() {
        LOGGER.info("Get all drones registered in the system");
        List<Drone> allDrones = apiService.getAllDrones();
        return ResponseEntity.ok(allDrones);
    }

}

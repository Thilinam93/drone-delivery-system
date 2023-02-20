package com.drone.dronedeliverysystem.job;

import com.drone.dronedeliverysystem.exception.BatteryLevelUpdateFailedException;
import com.drone.dronedeliverysystem.model.Drone;
import com.drone.dronedeliverysystem.model.DroneBatteryHistory;
import com.drone.dronedeliverysystem.repository.DroneBatteryHistoryRepository;
import com.drone.dronedeliverysystem.repository.DroneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class DroneBatteryCheckScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DroneBatteryCheckScheduler.class);
    @Autowired
    DroneRepository droneRepository;
    @Autowired
    DroneBatteryHistoryRepository droneBatteryHistoryRepository;



    @Scheduled(fixedDelayString = "120000")
    public void checkDroneBatteryLevelAndLog() {
        List<Drone> droneList = droneRepository.findAll();
        LOGGER.info("[{}] of Drones retrieved for battery level check", droneList.size());

        try {
            List<DroneBatteryHistory> droneBatteryHistories = droneList.stream()
                    .map(drone -> droneBatteryHistoryRepository.save(
                            DroneBatteryHistory
                                    .builder()
                                    .droneId(drone.getDroneId())
                                    .batteryPercentage( drone.getBatteryPercentage())
                                    .loggedTime(new Date())
                                    .build()))
                    .collect(Collectors.toList());
            LOGGER.info("Successfully added the log to the Data Base for Drones : [{}] ", droneBatteryHistories);
        } catch (Exception ex) {
            LOGGER.error("Failed to add the log to the Data Base for Drones");
            throw new BatteryLevelUpdateFailedException("Failed to add the log to the Data Base for Drones !", ex.getMessage());
        }


    }


    @Scheduled(fixedDelayString = "10000")
    public void reduceDroneBatteryLevelWithTime() {
        List<Drone> droneList = droneRepository.findAll();

        for (Drone drone:droneList
             ) {
            if(drone.getBatteryPercentage() > 0){
                drone.setBatteryPercentage(drone.getBatteryPercentage() - 0.5F);
                droneRepository.save(drone);
            }
        }
    }
}

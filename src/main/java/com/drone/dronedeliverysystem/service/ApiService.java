package com.drone.dronedeliverysystem.service;

import com.drone.dronedeliverysystem.model.Drone;
import com.drone.dronedeliverysystem.model.Medication;


import java.util.List;

public interface ApiService {


    Drone registerNewDrone(Drone drone);

    Drone loadMedicationToTheDrone(Integer droneId, List<Integer> medicationList);

    List<Medication> getLoadedMedicationsByDroneId(Integer droneId);

    Drone getDroneDetailsById(Integer droneId);

    float getDroneBatteryLevelById(Integer droneId);

    List<Drone> getAllAvailableDrones();

    List<Drone> getAllDrones();

}

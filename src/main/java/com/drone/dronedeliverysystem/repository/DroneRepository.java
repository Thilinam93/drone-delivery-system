package com.drone.dronedeliverysystem.repository;

import com.drone.dronedeliverysystem.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface DroneRepository extends JpaRepository<Drone, Integer> {



}

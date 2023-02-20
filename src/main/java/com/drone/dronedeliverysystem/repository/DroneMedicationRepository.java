package com.drone.dronedeliverysystem.repository;

import com.drone.dronedeliverysystem.model.DroneMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneMedicationRepository extends JpaRepository<DroneMedicine, Integer> {
}

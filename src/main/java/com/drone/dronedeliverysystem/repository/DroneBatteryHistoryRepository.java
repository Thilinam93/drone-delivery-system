package com.drone.dronedeliverysystem.repository;

import com.drone.dronedeliverysystem.model.DroneBatteryHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneBatteryHistoryRepository extends JpaRepository<DroneBatteryHistory, Integer> {
}

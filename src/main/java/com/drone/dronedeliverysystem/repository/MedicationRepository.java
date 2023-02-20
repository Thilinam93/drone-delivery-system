package com.drone.dronedeliverysystem.repository;

import com.drone.dronedeliverysystem.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {
}

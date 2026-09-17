package dev.sidebit.iot_home_back.repositories;

import dev.sidebit.iot_home_back.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor,Integer> {
}

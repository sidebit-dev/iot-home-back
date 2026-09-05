package dev.sidebit.iot_home_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sidebit.iot_home_back.entities.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}

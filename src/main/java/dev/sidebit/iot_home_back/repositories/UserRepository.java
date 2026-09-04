package dev.sidebit.iot_home_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sidebit.iot_home_back.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}

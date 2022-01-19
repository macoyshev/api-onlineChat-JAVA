package com.macoyshev.restAPI.store.repositories;

import com.macoyshev.restAPI.store.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

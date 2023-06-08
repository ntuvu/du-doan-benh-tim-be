package com.example.data_mining.repositories;

import com.example.data_mining.models.HealthIndicators;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthIndicatorsRepository extends JpaRepository<HealthIndicators, Integer> {

}
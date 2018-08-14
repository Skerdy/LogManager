package com.skerdy.logkafkarayonit.repositories;

import com.skerdy.logkafkarayonit.models.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LogRepository extends JpaRepository<LogEntity, Long > {

}

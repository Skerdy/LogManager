package com.skerdy.logkafkarayonit.repositories;

import com.skerdy.logkafkarayonit.models.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;


public interface LogRepository extends JpaRepository<LogEntity, Long > {

}

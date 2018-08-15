package com.skerdy.logkafkarayonit.Services;

import com.skerdy.logkafkarayonit.models.LogEntity;
import com.skerdy.logkafkarayonit.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;


    public List<LogEntity> getAll(){
        return this.logRepository.findAll();
    }

    public void save (LogEntity logEntity){
        this.logRepository.save(logEntity);
    }

}

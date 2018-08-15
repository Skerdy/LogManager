package com.skerdy.logkafkarayonit.controllers;



import com.skerdy.logkafkarayonit.models.LogEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/logs")
@RestController
public class LogController {

    @GetMapping
    public List<LogEntity> getAll(){
        List<LogEntity> logList =  new ArrayList<>();
        return logList;
    }


    @GetMapping("/file")
    public List<LogEntity> getAllFiles(){
        List<LogEntity> logEntities = new ArrayList<>();
        logEntities.add(new LogEntity("data 1", "type 1", "mesazhi i logut"));
        logEntities.add(new LogEntity("data 2", "type 2", "mesazhi i logut 2"));
        return logEntities;
    }

}

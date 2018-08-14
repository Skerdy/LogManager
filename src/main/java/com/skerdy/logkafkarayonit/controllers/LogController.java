package com.skerdy.logkafkarayonit.controllers;


import com.skerdy.logkafkarayonit.models.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/logs")
@RestController
public class LogController {

    @GetMapping
    public List<Log> getAll(){
        List<Log> logList =  new ArrayList<>();
        return logList;
    }
}

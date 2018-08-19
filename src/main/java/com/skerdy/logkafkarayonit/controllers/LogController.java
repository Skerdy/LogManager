package com.skerdy.logkafkarayonit.controllers;



import com.skerdy.logkafkarayonit.LogKafkaRayonitApplication;
import com.skerdy.logkafkarayonit.Utils.LogUtils;
import com.skerdy.logkafkarayonit.models.LogEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("api/v1/logs")
@RestController
public class LogController {

    @GetMapping
    public List<LogEntity> getAll() throws FileNotFoundException {
        //per momentin funskioni merr nga db esht caktivizuar pasi problemit te konfigurimit te SQLite
        return getAllFiles();
    }


    @GetMapping("/file")
    public List<LogEntity> getAllFiles() throws FileNotFoundException {
        List<LogEntity> logEntities = new ArrayList<>();
        return LogUtils.getAllLogsFromFile(LogKafkaRayonitApplication.FILE_PATH);
    }

}

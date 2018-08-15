package com.skerdy.logkafkarayonit.Utils;

import com.skerdy.logkafkarayonit.models.Log;
import com.skerdy.logkafkarayonit.models.LogEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogUtils {

    public static List<LogEntity> getAllLogsFromFile(String filePath) throws FileNotFoundException {
        List<LogEntity> logEntities = new ArrayList<>();
        try {
            try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
                for(String line; (line = br.readLine()) != null; ) {
                    System.out.println(line);
                    logEntities.add(createLogFromLine(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logEntities;
    }

    public static  LogEntity createLogFromLine(String line) {
        LogEntity logEntity;
        String logType, message;
        logType = Log.UNKNOWN;
        String[] strings =  line.split("\\|\\|");
        if(strings.length==2) {
            logType = strings[0];
            message = strings[1];
        }
        else{
            message = line;
            logType = Log.UNKNOWN;
        }

        switch (logType.trim()){
            case Log.ERROR :
                logEntity = new LogEntity(new Date(), Log.ERROR, message);
                break;
            case Log.WARNING :
                logEntity = new LogEntity(new Date(), Log.WARNING, message);
                break;
            default:
                logEntity = new LogEntity(new Date(), Log.UNKNOWN, message);
                break;
        }
        return logEntity;
    }

    public static Log createLogFromLogEntity(LogEntity logEntity){
        Log log = new Log();
        log.setDate(logEntity.getDate());
        log.setType(logEntity.getType());
        log.setMessage(logEntity.getMessage());
        return log;
    }
}

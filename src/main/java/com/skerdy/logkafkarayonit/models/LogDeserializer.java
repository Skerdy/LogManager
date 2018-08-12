package com.skerdy.logkafkarayonit.models;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class LogDeserializer implements Deserializer<Log> {

    @Override
    public Log deserialize(String arg0, byte[] devBytes) {
        ObjectMapper mapper = new ObjectMapper();
        Log log = null;
        try {
            log = mapper.readValue(devBytes, Log.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return log;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {
        // TODO Auto-generated method stub

    }

}

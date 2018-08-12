package com.skerdy.logkafkarayonit.LogTailer;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListenerAdapter;

import java.util.Date;

public class LogTailListenerAdapter extends TailerListenerAdapter {

    private LogTailListener logTailListener;

    public LogTailListenerAdapter ( LogTailListener logTailListener){
        this.logTailListener = logTailListener;
    }


    @Override
    public void handle(String line) {
        super.handle(line);
        logTailListener.onAddedNewLog(line, new Date());
    }
}

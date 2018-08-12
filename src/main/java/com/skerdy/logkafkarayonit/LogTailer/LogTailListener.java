package com.skerdy.logkafkarayonit.LogTailer;

import java.util.Date;

public interface LogTailListener {

   void onAddedNewLog(String message, Date date);
}

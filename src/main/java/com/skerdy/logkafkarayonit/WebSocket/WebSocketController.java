package com.skerdy.logkafkarayonit.WebSocket;


import com.skerdy.logkafkarayonit.models.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

    @MessageMapping("/send/message")
    public void onReceivedMesage (String message){
    }

    public void sendMessage (String message){
    }


    @CrossOrigin(allowedHeaders = "Access-Control-Allow-Origin")
    public  void sendLog(Log log){
        this.template.convertAndSend("/logEndPoint", log);
    }

}

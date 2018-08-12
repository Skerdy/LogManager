package com.skerdy.logkafkarayonit.WebSocket;


import com.skerdy.logkafkarayonit.models.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    WebSocketController(SimpMessagingTemplate template){
        this.template = template;
        this.template.convertAndSend("/chat", new SimpleDateFormat("HH:mm:ss").format(new Date()) + " - " + "mesazh random");
        System.out.println("U dergua nje mesazh ne chat");

    }

    @MessageMapping("/send/message")
    public void onReceivedMesage (String message){
        System.out.println("Erdhi nje mesazh nga front end");
        this.template.convertAndSend("/chat", new SimpleDateFormat("HH:mm:ss").format(new Date()) + " - " + message);
    }

    public void sendMessage (String message){
        System.out.println("U dergua nje mesazh nga consumeri me anen e websocket");
        this.template.convertAndSend("/chat", new SimpleDateFormat("HH:mm:ss").format(new Date()) + " - " + message);
    }

    public  void sendLog(Log log){

        this.template.convertAndSend("/logEndPoint", log);
    }

}

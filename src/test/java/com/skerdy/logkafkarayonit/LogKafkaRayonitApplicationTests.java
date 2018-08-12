package com.skerdy.logkafkarayonit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogKafkaRayonitApplicationTests {

	@Autowired
	private  SimpMessagingTemplate template;

	@Test
	public void contextLoads() throws InterruptedException {

		while(true) {
			this.template.convertAndSend("/chat", new SimpleDateFormat("HH:mm:ss").format(new Date()) + " - " + "mesazh random");
			System.out.println("U dergua nje mesazh ne chat ne TEST MODE");
		}

	}

}

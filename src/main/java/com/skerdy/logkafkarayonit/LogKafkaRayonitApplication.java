package com.skerdy.logkafkarayonit;

import com.skerdy.logkafkarayonit.Kafka.LogProducer;
import com.skerdy.logkafkarayonit.LogTailer.LogTailListener;
import com.skerdy.logkafkarayonit.LogTailer.LogTailListenerAdapter;
import com.skerdy.logkafkarayonit.models.Log;
import org.apache.commons.io.input.Tailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@SpringBootApplication
public class LogKafkaRayonitApplication implements CommandLineRunner, LogTailListener {

	private static Tailer tailer;

	public static void main(String[] args)  {
		SpringApplication.run(LogKafkaRayonitApplication.class, args);
	}

	@Autowired
	private LogProducer logProducer;

	@Override
	public void run(String... strings) throws Exception {
		tailer = Tailer.create(new File("C://Users//German//Desktop//log_file.txt"), new LogTailListenerAdapter(this)
		,1000, true , true);
	}

	@Override
	public void onAddedNewLog(String message, Date date) {
		System.out.println("U shtua rresht i ri!");
		logProducer.send(new Log(new SimpleDateFormat("HH:mm:ss").format(date), Log.ERROR, message));
	}
}

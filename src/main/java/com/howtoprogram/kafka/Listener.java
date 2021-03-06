package com.howtoprogram.kafka;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	@KafkaListener(id = "demo", topics = "kafka_test03", group = "group_test")
	public void listen(ConsumerRecord<?, ?> record) {
		System.out.println(">>>>>Listener consumer record:"+record);
		countDownLatch1.countDown();
	}

}
package com.cass.demo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "${kafka.topic}", containerFactory = "kafkaListenerContainerFactory")
	public void consume(String person) {
		logger.info("Consumed message -> person : {} ", person);
	}
}
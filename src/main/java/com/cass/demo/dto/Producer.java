package com.cass.demo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);

	@Value("${kafka.topic}")
	private String topic;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String person) {
		logger.info("Producing message person : {} ", person);
		this.kafkaTemplate.send(topic, person);
	}
}
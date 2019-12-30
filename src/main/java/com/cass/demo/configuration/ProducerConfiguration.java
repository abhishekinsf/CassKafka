package com.cass.demo.configuration;


import com.cass.demo.dto.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;


public class ProducerConfiguration {
	@Value("${spring.kafka.bootstrap.servers}")
	private String bootstrapServers;

	@Bean
	public Map<String, Object> producerConfigProps() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		return new DefaultKafkaProducerFactory(producerConfigProps());
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate(producerFactory());
	}

	@Bean
	public Producer sender() {
		return new Producer();
	}
}
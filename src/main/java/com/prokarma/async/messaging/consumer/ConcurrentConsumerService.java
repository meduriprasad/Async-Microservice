package com.prokarma.async.messaging.consumer;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.function.Function;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.prokarma.async.broker.consumer.DefaultConcurrentConsumerService;
import com.prokarma.async.messaging.producer.KafkaProducerWrapper;
import com.prokarma.async.messaging.tasks.MiRequestTask;
import com.prokarma.async.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConcurrentConsumerService extends DefaultConcurrentConsumerService {

	@Autowired  
	KafkaProducerWrapper kafkaProducerWrapper;

	@Autowired
	UserService userService;
	
	@Value("${mi.request.topic}")
    private String consumetopic;
	
	@Value("${mi.response.topic}")
	private String producetopic;
	
    private static final Integer CONSUMER_NUM_THREADS = 1;
    private static final Integer LISTENER_NUM_THREADS = 1;
    private static final Integer EXECUTOR_NUM_THREADS = 8;
    
    @Autowired
    private ConsumerConfigFactory consumerConfigFactory;
    
    private ObjectMapper mapper;
    
 
    @PostConstruct
    public void startConsuming() {
    	listenerExecService = Executors.newFixedThreadPool(LISTENER_NUM_THREADS);
    	handlerExecService = Executors.newFixedThreadPool(EXECUTOR_NUM_THREADS);
        
        consumerConfig = consumerConfigFactory.getConsumerConfig();
        topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(consumetopic, CONSUMER_NUM_THREADS);
        
        mapper = new ObjectMapper();
        
        super.start();
    }
    
    @Override
	public Function<String, Runnable> getHandlerTaskFactory(String topic) {
		return (message) -> new MiRequestTask(message, mapper, userService, kafkaProducerWrapper, producetopic);
	}
}
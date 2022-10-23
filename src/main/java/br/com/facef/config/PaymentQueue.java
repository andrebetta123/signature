package br.com.facef.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentQueue {
 
    @Autowired
    private RabbitTemplate rabbitTemplate;
 
    @Autowired
    private Queue queue;

    public void send(String order) {
    	System.out.println("Teste Send");
        rabbitTemplate.convertAndSend(this.queue.getName(), order);
    }
}

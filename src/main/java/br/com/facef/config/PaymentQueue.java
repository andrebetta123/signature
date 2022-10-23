package br.com.facef.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentQueue {
 
    @Autowired
    private RabbitTemplate rabbitTemplate;
 
//    @Autowired
//    private Queue queue;
// 
    public void send(String order) {
//        rabbitTemplate.convertAndSend();
//        rabbitTemplate.convertAndSend(this.queue.getName(), order);
        String messageString = "Hello Rabbit @" + LocalDateTime.now().format(DateTimeFormatter.ISO_TIME);
        rabbitTemplate.convertAndSend("hello", messageString);      
    }
}

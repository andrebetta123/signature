package br.com.facef;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SignatureApplication {
	
	@Value("${queue.order.name}")
	private String paymentQueue;
	  
	public static void main(String[] args) {
		SpringApplication.run(SignatureApplication.class, args);
	}
	
    @Bean
    public Queue queue() {
//        return new Queue(paymentQueue, true);
        return new Queue("hello");
    }	
}

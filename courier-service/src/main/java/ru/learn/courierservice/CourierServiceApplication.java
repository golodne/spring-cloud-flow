package ru.learn.courierservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.List;

@SpringBootApplication
@EnableBinding(Sink.class)
@Slf4j
public class CourierServiceApplication {

	@StreamListener(Sink.INPUT)
	public void orderDispatched(List<Product> products) {
		products.forEach(product -> {
			log.info("Order delivered : {}" + product);
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(CourierServiceApplication.class, args);
	}

}

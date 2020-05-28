package ru.learn.discountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableBinding(Processor.class)
public class DiscountServiceApplication {

	Random r = new Random();

	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public List<Product> transform(List<Product> list) {
		return list.stream()
				   .map(x -> new Product(x.getId(),x.getName(),x.getPrice()-r.nextInt(1000)))
				   .collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(DiscountServiceApplication.class, args);
	}

}

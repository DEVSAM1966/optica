package com.minka.optica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.minka.optica", "com.minka.optica.mapper", "com.minka.optica.services"})
public class OpticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpticaApplication.class, args);
	}

}

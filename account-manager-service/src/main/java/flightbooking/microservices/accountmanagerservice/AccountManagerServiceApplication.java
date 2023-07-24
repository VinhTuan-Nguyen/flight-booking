package flightbooking.microservices.accountmanagerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
	basePackages = {
		"flightbooking.microservices.accountmanagerservice.controllers",
		"flightbooking.microservices.accountmanagerservice.implementations"
	}
)
public class AccountManagerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountManagerServiceApplication.class, args);
	}

}

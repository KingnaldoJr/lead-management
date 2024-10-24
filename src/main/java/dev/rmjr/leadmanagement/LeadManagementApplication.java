package dev.rmjr.leadmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LeadManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadManagementApplication.class, args);
	}

}

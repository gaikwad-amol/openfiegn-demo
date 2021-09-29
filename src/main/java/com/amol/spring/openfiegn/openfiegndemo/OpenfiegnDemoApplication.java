package com.amol.spring.openfiegn.openfiegndemo;

import com.amol.spring.openfiegn.openfiegndemo.client.CustomerServiceClient;
import com.amol.spring.openfiegn.openfiegndemo.client.JSONPlaceHolderClient;
import com.amol.spring.openfiegn.openfiegndemo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class OpenfiegnDemoApplication {

	private static CustomerServiceClient customerServiceClient;
	private static JSONPlaceHolderClient jsonPlaceHolderClient;

	@Autowired
	public OpenfiegnDemoApplication(@Autowired @Lazy CustomerServiceClient customerServiceClient,
									@Autowired @Lazy JSONPlaceHolderClient jsonPlaceHolderClient) {
		OpenfiegnDemoApplication.customerServiceClient = customerServiceClient;
		OpenfiegnDemoApplication.jsonPlaceHolderClient = jsonPlaceHolderClient;

	}

//https://www.baeldung.com/spring-cloud-openfeign
	public static void main(String[] args) {
		SpringApplication.run(OpenfiegnDemoApplication.class, args);
		List<Customer> customers = customerServiceClient.getCustomers();
		System.out.println(customers);
	}

}

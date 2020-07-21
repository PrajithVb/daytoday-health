package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.modal.Person;
import com.example.demo.repository.PersonRepository;

@SpringBootApplication
public class DemoDaytodayApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DemoDaytodayApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			 repository.deleteAll();
//
//			    // save a couple of customers
//			    repository.save(new Person("Alice", "Smith"));
//			    repository.save(new Person("Bob", "Smith"));
//
//			    // fetch all customers
//			    System.out.println("Customers found with findAll():");
//			    System.out.println("-------------------------------");
//			    for (Person customer : repository.findAll()) {
//			      System.out.println(customer);
//			    }
//			    System.out.println();
//
//			    // fetch an individual customer
//			    System.out.println("Customer found with findByFirstName('Alice'):");
//			    System.out.println("--------------------------------");
//			    System.out.println(repository.findByFirstName("Alice"));
//
//			    System.out.println("Customers found with findByLastName('Smith'):");
//			    System.out.println("--------------------------------");
//			    for (Person customer : repository.findByLastName("Smith")) {
//			      System.out.println(customer);
//			    }
//
//		};
//}

	   


}

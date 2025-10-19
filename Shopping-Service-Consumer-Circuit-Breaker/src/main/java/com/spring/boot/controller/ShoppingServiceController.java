package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.config.IBillingServiceRestConsumer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingServiceController {

	@Autowired
	private IBillingServiceRestConsumer consumer;
	
	@GetMapping("/info")
	@CircuitBreaker(name = "Shopping-Service", fallbackMethod = "bilingFallback")
	public String displayShoppingDetails() {
		System.out.println("shoppingController :: client comp class name :: "+consumer.getClass());
		return "desiplay shopping details :: "+consumer.fetchBillDetails();
	}
	
	public String bilingFallback(Exception e){
		System.out.println("ShoppingServiceController.billingFallback()");
		return "Billing Operations are out of service";
	}
}

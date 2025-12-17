package com.ecommerce.inventoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InventoryController {
	
	
	
	@GetMapping("/health")
    public String health() {
        return "Spring Boot running on AWS EC2";
    }

}

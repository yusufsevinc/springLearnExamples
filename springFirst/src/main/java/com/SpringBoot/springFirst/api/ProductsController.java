package com.SpringBoot.springFirst.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productsController")
public class ProductsController {
	
	@GetMapping("/mesaj")
	public String mesaj() {
		return "Merhaba Dünyaa";
	}
	
	
	

}

package com.sanchezc.bookshop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanchezc.bookshop.service.BookPricingService;

@RestController
@RequestMapping("/api/books")
public class BookPricingController {
	@Autowired
	private BookPricingService bookPricingService;

	@PostMapping("/calculate-price")
	public double calculatePrice(@RequestBody Map<String, Integer> basket) {
		return bookPricingService.calculatePrice(basket);
	}

}
